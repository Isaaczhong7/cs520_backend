package org.example.cs520.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.cs520.annotation.AccessLimit;
import org.example.cs520.dto.MessageDTO;
import org.example.cs520.dto.MessageInfoDTO;
import org.example.cs520.dto.NoticeBackDTO;
import org.example.cs520.dto.NoticeDTO;
import org.example.cs520.service.MessageService;
import org.example.cs520.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Api(tags = "messages")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * send message
     *
     * @param messageVO message info
     * @return {@link Result <>}
     */
    @AccessLimit(seconds = 60, maxCount = 1)
    @ApiOperation(value = "send message")
    @PostMapping("/messages")
    public Result<?> saveMessage(@Valid @RequestBody MessageVO messageVO) {
        messageService.saveMessage(messageVO);
        return Result.ok();
    }

    /**
     * get chats
     *
     * @return {@link Result< MessageDTO >} message list
     */
    @ApiOperation(value = "get chats")
    @GetMapping("/messages")
    public Result<List<MessageDTO>> listMessages() {
        return Result.ok(messageService.listMessages());
    }

    /**
     * get message
     *
     * @param conversationVO conversation info
     * @return {@link Result<MessageInfoDTO>} conversation info list
     */
    @ApiOperation(value = "get message")
    @PostMapping("/messages/info")
    public Result<MessageInfoDTO> listMessagesInfo(@Valid @RequestBody ConversationVO conversationVO) {
        return Result.ok(messageService.listMessagesInfo(conversationVO));
    }

    /**
     * update conversation info
     *
     * @param conversationVO conversation info
     */
    @ApiOperation(value = "update conversation info")
    @PostMapping("/conversations")
    public Result<?> updateConversations(@Valid @RequestBody ConversationVO conversationVO) {
        messageService.updateConversations(conversationVO);
        return Result.ok();
    }

    /**
     * search notification
     *
     * @return {@link Result< Map >} notification list
     */
    @ApiOperation(value = "search notification")
    @GetMapping("/notices")
    public Result<Map<String, Integer>> listNotices() {
        return Result.ok(messageService.listNotices());
    }

    /**
     * get notification details
     *
     * @param type notification type
     * @return {@link Result<NoticeDTO>} notification details list
     */
    @ApiOperation(value = "get notification details")
    @GetMapping("/notices/{type}")
    public Result<PageResult<NoticeDTO>> listNoticesInfo(@PathVariable("type") String type, @RequestParam Integer size,
                                                         @RequestParam Integer current) {
        return Result.ok(messageService.listNoticesInfo(type, current, size));
    }

    /**
     * send notification
     *
     * @param messageVO notification info
     * @return {@link Result <>}
     */
    @AccessLimit(seconds = 60, maxCount = 1)
    @ApiOperation(value = "send notification")
    @PostMapping("/admin/messages")
    public Result<?> saveAdminMessage(@Valid @RequestBody MessageVO messageVO) {
        messageService.saveAdminMessage(messageVO);
        return Result.ok();
    }

    /**
     * get notification details
     *
     * @return {@link Result<NoticeBackDTO>} notification details list
     */
    @ApiOperation(value = "get notification details")
    @GetMapping("/admin/notices")
    public Result<PageResult<NoticeBackDTO>> listNoticesBackInfo(ConditionVO condition) {
        return Result.ok(messageService.listNoticesBackInfo(condition));
    }

    /**
     * update notification details
     *
     * @param messageVO notification info
     * @return {@link Result<>}
     */
    @ApiOperation(value = "update notification details")
    @PostMapping("/admin/notices")
    public Result<?> updateNoticesBackInfo(@Valid @RequestBody MessageVO messageVO) {
        messageService.updateNoticesBackInfo(messageVO);
        return Result.ok();
    }
}
