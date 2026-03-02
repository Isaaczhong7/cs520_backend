package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "page object")
public class PageResult<T> {
    /**
     * page list
     */
    @ApiModelProperty(name = "recordList", value = "page list", required = true, dataType = "List<T>")
    private List<T> recordList;

    /**
     * total
     */
    @ApiModelProperty(name = "count", value = "total", required = true, dataType = "Integer")
    private Integer count;
}
