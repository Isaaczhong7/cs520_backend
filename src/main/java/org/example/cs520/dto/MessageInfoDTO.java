package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfoDTO {
    /**
     * user id
     */
    private Integer userId;

    /**
     * nickname
     */
    private String nickname;

    /**
     * avatar
     */
    private String avatar;

    /**
     * messages
     */
    private Map<String, Object> messages;
}

