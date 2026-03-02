package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * background tag
 * @author Xinyuan Xu, Isaac 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagBackDTO {
    private Integer id;

    private String tagName;

    private LocalDateTime createTime;
}
