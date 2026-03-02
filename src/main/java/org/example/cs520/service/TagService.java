package org.example.cs520.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.cs520.dto.TagBackDTO;
import org.example.cs520.dto.TagDTO;
import org.example.cs520.entity.Tag;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.TagVO;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
public interface TagService extends IService<Tag> {
    /**
     * listTags
     *
     * @return tags
     */
    PageResult<TagDTO> listTags();

    /**
     * listTagBackDTO
     *
     * @param condition condition
     * @return {@link PageResult<TagBackDTO>} tags
     */
    PageResult<TagBackDTO> listTagBackDTO(ConditionVO condition);

    /**
     * deleteTags
     *
     * @param tagIdList tagIds
     */
    void deleteTag(List<Integer> tagIdList);

    /**
     * saveOrUpdateTag
     *
     * @param tagVO tag
     */
    void saveOrUpdateTag(TagVO tagVO);
}

