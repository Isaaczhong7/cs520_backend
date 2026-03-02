package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    /**
     * conversation id
     */
    private String conversationCode;

    /**
     * nickname
     */
    private String nickname;

    /**
     * avatar
     */
    private String avatar;

    /**
     * messageContent
     */
    private String messageContent;

    /**
     * send time
     */
    private LocalDateTime createTime;

    /**
     * messageCount
     */
    private Integer messageCount;

    /**
     * messageUnreadCount
     */
    private Integer messageUnreadCount;

    /**
     * isTop
     */
    private Integer isTop;
}