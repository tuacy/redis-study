package com.tuacy.redis.study.param;

import java.util.Set;

/**
 * @name: RedisIntegerSetParam
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: 把Set数据设置到redis里面去
 */
public class RedisSetObjectSetParam {

    private String redisKey;
    private Set<String> redisValue;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public Set<String> getRedisValue() {
        return redisValue;
    }

    public void setRedisValue(Set<String> redisValue) {
        this.redisValue = redisValue;
    }
}
