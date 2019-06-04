package com.tuacy.redis.study.param;

/**
 * @name: RedisIntegerSetParam
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: 把String数据设置到redis里面去
 */
public class RedisStringSetParam {

    private String redisKey;
    private String redisValue;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public String getRedisValue() {
        return redisValue;
    }

    public void setRedisValue(String redisValue) {
        this.redisValue = redisValue;
    }
}
