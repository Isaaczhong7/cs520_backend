package org.example.cs520.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.cs520.BizException;
import org.example.cs520.dao.TagDao;
import org.example.cs520.dto.TagBackDTO;
import org.example.cs520.dto.TagDTO;
import org.example.cs520.entity.Tag;
import org.example.cs520.service.TagService;
import org.example.cs520.utils.BeanCopyUtils;
import org.example.cs520.utils.PageUtils;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public PageResult<TagDTO> listTags() {
        // Query tag list
        List<Tag> tagList = tagDao.selectList(null);
        // Convert DTO
        List<TagDTO> tagDTOList = BeanCopyUtils.copyList(tagList, TagDTO.class);
        // Query the number of tags
        Integer count = Math.toIntExact(tagDao.selectCount(null));
        return new PageResult<>(tagDTOList, count);
    }

    @Override
    public PageResult<TagBackDTO> listTagBackDTO(ConditionVO condition) {
        // Query the number of tags
        int count = Math.toIntExact(tagDao.selectCount(new LambdaQueryWrapper<Tag>()
                .like(StringUtils.isNotBlank(condition.getKeywords()), Tag::getTagName, condition.getKeywords())));
        if (count == 0) {
            return new PageResult<>();
        }
        // Paginated query tag list
        List<TagBackDTO> tagList = tagDao.listTagBackDTO(PageUtils.getLimitCurrent(), PageUtils.getSize(), condition);
        return new PageResult<>(tagList, count);
    }

    @Override
    public void deleteTag(List<Integer> tagIdList) {
        tagDao.deleteBatchIds(tagIdList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrUpdateTag(TagVO tagVO) {
        // Query whether the tag name exists
        Tag existTag = tagDao.selectOne(new LambdaQueryWrapper<Tag>()
                .select(Tag::getId)
                .eq(Tag::getTagName, tagVO.getTagName()));
        if (Objects.nonNull(existTag) && !existTag.getId().equals(tagVO.getId())) {
            throw new BizException("Tag name already exists");
        }
        Tag tag = BeanCopyUtils.copyObject(tagVO, Tag.class);
        this.saveOrUpdate(tag);
    }
}
