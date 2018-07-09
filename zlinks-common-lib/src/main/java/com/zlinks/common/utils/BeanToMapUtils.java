package com.zlinks.common.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * Created by zhangjh on 2016/12/6.
 * map和bean互转
 */
public enum BeanToMapUtils {
    INSTANCE;

    /**
     * map转bean：不支持级联map
     *
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        BeanUtils.populate(obj, map);
        return obj;
    }

    /**
     * bean转map
     *
     * @param obj
     * @return
     */
    public Map<?, ?> objectToMap(Object obj) {
        if (obj == null)
            return null;

        return new org.apache.commons.beanutils.BeanMap(obj);
    }


}

