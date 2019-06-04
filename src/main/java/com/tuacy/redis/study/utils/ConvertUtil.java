package com.tuacy.redis.study.utils;

/**
 * @name: ConvertUtil
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description:
 */
public class ConvertUtil {

    @SuppressWarnings("unchecked")
    public static <T> T convert(Object source) {
        if (source == null) {
            return null;
        }
        return (T) (source);
    }

}
