package com.tuacy.redis.study.param;

/**
 * @name: RedisIntegerSetParam
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: 获取redis里面的数据
 */
public class RedisGetParam {

    private String redisKey;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }
}
