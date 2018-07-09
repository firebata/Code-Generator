package com.zlinks.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangjh 2017/11/11.
 */
public class RBeanUtils extends BeanUtils {


    /**
     * 对象属性copy 并且 提供字段为null时不copy
     *
     * @param source
     * @param target
     * @param ignoreProperties 忽略的字段
     * @param isFilterNull
     */
    public static void copyProperties(Object source, Object target, List<String> ignoreProperties, boolean isFilterNull) {
        if (isFilterNull) {
            //如果source 某些字段为空时,把对应字段添加到 ignoreProperties List 里,忽略copy
            Arrays.stream(source.getClass().getSuperclass().getDeclaredFields()).filter(field -> {
                try {
                    return field.get(source) == null;
                } catch (IllegalAccessException e) {
                    return false;
                }
            }).forEach(field -> ignoreProperties.add(field.getName()));
        }
        BeanUtils.copyProperties(source, target, ignoreProperties.toArray(new String[]{}));
    }
}
