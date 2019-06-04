package com.tuacy.redis.study.param;

import java.util.HashMap;

/**
 * @name: RedisIntegerSetParam
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: 获取redis里面的数据
 */
public class RedisHashObjectSetParam {

    private String redisKey;
    private HashMap<String, String> redisValue;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public HashMap<String, String> getRedisValue() {
        return redisValue;
    }

    public void setRedisValue(HashMap<String, String> redisValue) {
        this.redisValue = redisValue;
    }
}
