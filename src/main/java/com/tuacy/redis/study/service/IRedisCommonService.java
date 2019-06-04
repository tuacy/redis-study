package com.tuacy.redis.study.service;

/**
 * @name: IRedisCommonService
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description:
 */
public interface IRedisCommonService {
    /**
     * 设置key对应失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return 是否设置成功
     */
    boolean expire(String key, long time);

    /**
     * 获取key对应过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    long getExpire(String key);

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return 对应key值是否存在
     */
    boolean hasKey(String key);

    /**
     * 删除key
     *
     * @param key 可以传一个值 或多个
     */
    void del(String... key);
}
