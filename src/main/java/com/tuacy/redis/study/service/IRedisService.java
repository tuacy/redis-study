package com.tuacy.redis.study.service;

/**
 * @name: IRedisService
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description:
 */
public interface IRedisService<V> extends IRedisCommonService {

    //============================String=============================

    /**
     * redis String类型 获取数据
     *
     * @param key 键
     * @return 值
     */
    V get(String key);

    /**
     * redis String类型 存入数据
     *
     * @param key   键
     * @param value 值
     * @return 是否成功
     */
    boolean set(String key, V value);
}
