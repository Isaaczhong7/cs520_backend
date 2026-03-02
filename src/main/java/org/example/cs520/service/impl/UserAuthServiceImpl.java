package org.example.cs520.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.example.cs520.BizException;
import org.example.cs520.constant.CommonConst;
import org.example.cs520.constant.RedisPrefixConst;
import org.example.cs520.dao.UserAuthDao;
import org.example.cs520.dao.UserInfoDao;
import org.example.cs520.dao.UserRoleDao;
import org.example.cs520.dto.UserBackDTO;
import org.example.cs520.entity.UserAuth;
import org.example.cs520.entity.UserInfo;
import org.example.cs520.entity.UserRole;
import org.example.cs520.enums.RoleEnum;
import org.example.cs520.service.RedisService;
import org.example.cs520.service.UserAuthService;
import org.example.cs520.utils.PageUtils;
import org.example.cs520.utils.UserUtils;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.PasswordVO;
import org.example.cs520.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;

import static org.example.cs520.utils.CommonUtils.generateUUID;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthDao, UserAuth> implements UserAuthService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserAuthDao userAuthDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private Producer producer;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(UserVO user) {
        if (!checkInvitation(user)) {
            throw new BizException("Invitation code does not exist！");
        }
        // Verify whether the account is legal
        if (checkUser(user)) {
            throw new BizException("User already exist！");
        }
        // Add user information
        UserInfo userInfo = UserInfo.builder()
                .email(user.getUsername())
                .nickname(CommonConst.DEFAULT_NICKNAME + IdWorker.getId())
                .avatar("")
                .build();
        userInfoDao.insert(userInfo);
        // Bind user role
        int roleId = RoleEnum.STU.getRoleId();
        if (user.getRole().equals("instructor")) {
            roleId = RoleEnum.PROF.getRoleId();
        }
        UserRole userRole = UserRole.builder()
                .userId(userInfo.getId())
                .roleId(roleId)
                .build();
        userRoleDao.insert(userRole);
        // Add user account
        UserAuth userAuth = UserAuth.builder()
                .userInfoId(userInfo.getId())
                .username(user.getUsername())
                .password(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()))
                .loginType(1)
                .build();
        userAuthDao.insert(userAuth);
    }

    @Override
    public void updatePassword(UserVO user) {
        // Verify whether the account is legal
        if (!checkUser(user)) {
            throw new BizException("Not registered user！");
        }
        // Change password based on username
        userAuthDao.update(new UserAuth(), new LambdaUpdateWrapper<UserAuth>()
                .set(UserAuth::getPassword, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()))
                .eq(UserAuth::getUsername, user.getUsername()));
    }

    @Override
    public void updateAdminPassword(PasswordVO passwordVO) {
        // Check whether the old password is correct
        UserAuth user = userAuthDao.selectOne(new LambdaQueryWrapper<UserAuth>()
                .eq(UserAuth::getId, UserUtils.getLoginUser().getId()));
        // If it is correct, change the password; if it is wrong, it will prompt that it is incorrect.
        if (Objects.nonNull(user) && BCrypt.checkpw(passwordVO.getOldPassword(), user.getPassword())) {
            UserAuth userAuth = UserAuth.builder()
                    .id(UserUtils.getLoginUser().getId())
                    .password(BCrypt.hashpw(passwordVO.getNewPassword(), BCrypt.gensalt()))
                    .build();
            userAuthDao.updateById(userAuth);
        } else {
            throw new BizException("Wrong password");
        }
    }

    @Override
    public PageResult<UserBackDTO> listUserBackDTO(ConditionVO condition) {
        // Get the number of background users
        Integer count = userAuthDao.countUser(condition);
        if (count == 0) {
            return new PageResult<>();
        }
        // Get the background user list
        List<UserBackDTO> userBackDTOList = userAuthDao.listUsers(PageUtils.getLimitCurrent(), PageUtils.getSize(), condition);
        return new PageResult<>(userBackDTOList, count);
    }

    /**
     * Check if username exists
     *
     * @param user user data
     * @return result
     */
    private Boolean checkUser(UserVO user) {
        // Check if username exists
        UserAuth userAuth = userAuthDao.selectOne(new LambdaQueryWrapper<UserAuth>()
                .select(UserAuth::getUsername)
                .eq(UserAuth::getUsername, user.getUsername()));
        return Objects.nonNull(userAuth);
    }

    /**
     * Verify whether the user invitation code is legal
     *
     * @param user user data
     * @return result
     */
    private boolean checkInvitation(UserVO user) {
        return user.getInvitationCode().equals("123456");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importUsers(MultipartFile file) throws IOException {
        // Get excel table
        InputStream inputStream = file.getInputStream();
        ReadableWorkbook readableWorkbook = new ReadableWorkbook(inputStream);
        readableWorkbook.getSheets().forEach(sheet -> {
            try {
                Stream<Row> rows = sheet.openStream();
                rows.forEach(row -> {
                    if (row.getRowNum() == 1) {
                        return;
                    }
                    // Add user information
                    if (getCellValue(row, 0).orElse(null) != null &&
                            userAuthDao.selectCount(new LambdaQueryWrapper<UserAuth>().select(UserAuth::getUsername)
                                    .eq(UserAuth::getUsername, getCellValue(row, 0).orElse(null))) == 0){
                        UserInfo userInfo = UserInfo.builder()
                                .email(getCellValue(row, 0).orElse(null))
                                .nickname(getCellValue(row, 1).orElse(CommonConst.DEFAULT_NICKNAME + IdWorker.getId()))
                                .avatar("")
                                .intro(getCellValue(row, 2).orElse(null))
                                .phone(getCellValue(row, 3).orElse(null))
                                .build();
                        userInfoDao.insert(userInfo);
                        // Bind user role
                        UserRole userRole = UserRole.builder()
                                .userId(userInfo.getId())
                                .roleId(RoleEnum.STU.getRoleId())
                                .build();
                        userRoleDao.insert(userRole);
                        // Add user account
                        UserAuth userAuth = UserAuth.builder()
                                .userInfoId(userInfo.getId())
                                .username(userInfo.getEmail())
                                .password(BCrypt.hashpw("123456", BCrypt.gensalt()))
                                .loginType(4)
                                .build();
                        userAuthDao.insert(userAuth);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Optional<String> getCellValue(Row row, int cellIndex) {
        String cellValue = row.getCellAsString(cellIndex).orElse(null);
        if (StringUtils.isBlank(cellValue)) {
            return Optional.empty();
        }
        return Optional.of(cellValue);
    }

    @Override
    public void getCaptcha(HttpServletResponse response) {
        // Generate verification code
        // Generate random characters
        String text = producer.createText();
        // Generate pictures
        BufferedImage image = producer.createImage(text);

        // Owner of the verification code
        String captchaOwner = generateUUID();
        Cookie cookie = new Cookie("captchaOwner", captchaOwner);
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);
        // Save verification code to redis
        redisService.set(RedisPrefixConst.USER_CAPTCHA_KEY + captchaOwner, text, RedisPrefixConst.CAPTCHA_EXPIRE_TIME);

        // Output the image to the browser
        response.setContentType("image/png");
        try {
            ServletOutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            log.error("Response to verification code failed");
        }
    }

    @Override
    public Boolean checkCaptchaCode(String captchaOwner, String checkCode) {
        if (StringUtils.isBlank(checkCode)) {
            return false;
        }
        if (!checkCode.equals(redisService.get(RedisPrefixConst.USER_CAPTCHA_KEY + captchaOwner))) {
            throw new BizException("Verification code error！");
        }
        return true;
    }
}


