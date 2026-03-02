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
public class NoticeDTO {
    /**
     * id
     */
    private Integer id;

    /**
     * notice code
     */
    private String conversationCode;

    /**
     * notice content
     */
    private String messageContent;

    /**
     * sent time
     */
    private LocalDateTime createTime;
}

