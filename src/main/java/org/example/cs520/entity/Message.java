package org.example.cs520.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * messages
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_message")
public class Message {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * sender
     */
    private Integer fromId;

    /**
     * receiver
     */
    private Integer toId;

    private String ipAddress;

    private String ipSource;

    private String messageContent;

    private String conversationCode;

    /**
     * Has it been read
     */
    private Boolean status;

    private Boolean isDelete;

    private Integer isTop;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}

