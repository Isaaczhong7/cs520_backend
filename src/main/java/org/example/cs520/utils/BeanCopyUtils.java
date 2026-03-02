package org.example.cs520.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
public class BeanCopyUtils {
    /**
     * copy object
     *
     * @param source s
     * @param target t
     * @return {@link T}
     */
    public static <T> T copyObject(Object source, Class<T> target) {
        T temp = null;
        try {
            temp = target.newInstance();
            if (null != source) {
                org.springframework.beans.BeanUtils.copyProperties(source, temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * copy collection
     *
     * @param source s
     * @param target t
     * @return {@link List <T>} collection
     */
    public static <T, S> List<T> copyList(List<S> source, Class<T> target) {
        List<T> list = new ArrayList<>();
        if (null != source && !source.isEmpty()) {
            for (Object obj : source) {
                list.add(BeanCopyUtils.copyObject(obj, target));
            }
        }
        return list;
    }
}
