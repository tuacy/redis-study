package com.tuacy.redis.study.param;

import java.util.List;

/**
 * @name: RedisIntegerSetParam
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: 把List数据设置到redis里面去
 */
public class RedisListObjectSetParam {

    private String redisKey;
    private List<String> redisValue;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public List<String> getRedisValue() {
        return redisValue;
    }

    public void setRedisValue(List<String> redisValue) {
        this.redisValue = redisValue;
    }
}
