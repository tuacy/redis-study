package com.tuacy.redis.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @name: RedisServiceImpl
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: RedisTemplate<String, Object>
 */
@Service
public class RedisTemplateServiceImpl extends ARedisOperateImpl<Object> {

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
}
