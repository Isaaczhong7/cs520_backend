package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Integer id;

    private String roleName;

    private String roleLabel;

    private LocalDateTime createTime;

    private Integer isDisable;

    private List<Integer> resourceIdList;

    private List<Integer> menuIdList;

    /**
     * menu tree
     */
    private List<LabelOptionDTO> labelOptionDTOS;

    /**
     * api tree
     */
    private List<LabelOptionDTO> resourceOptionDTOS;
}
