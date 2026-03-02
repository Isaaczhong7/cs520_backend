package org.example.cs520.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
public class ResourceRoleDTO {
    private Integer id;

    private String url;

    private String requestMethod;

    private List<String> roleList;
}
