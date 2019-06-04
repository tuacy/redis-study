package com.tuacy.redis.study.param;

/**
 * @name: RedisIntegerSetParam
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: 把整数设置到redis里面去
 */
public class RedisIntegerSetParam {

    private String redisKey;
    private Integer redisValue;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public Integer getRedisValue() {
        return redisValue;
    }

    public void setRedisValue(Integer redisValue) {
        this.redisValue = redisValue;
    }
}
