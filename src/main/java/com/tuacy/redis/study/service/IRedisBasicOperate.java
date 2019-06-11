package com.tuacy.redis.study.service;

/**
 * @name: IRedisBasicOperate
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: redis基本操作
 */
public interface IRedisBasicOperate {
    /**
     * 设置key失效时间
     *
     * @param key        键
     * @param expireTime 时间(秒)
     * @return 是否设置成功
     */
    boolean expire(String key, long expireTime);

    /**
     * 获取key对应的失效时间
     *
     * @param key 键
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
     * @param key 可以传一个或多个值
     */
    void del(String... key);
}
