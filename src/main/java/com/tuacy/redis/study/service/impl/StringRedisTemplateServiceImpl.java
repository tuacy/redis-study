package com.tuacy.redis.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @name: StringRedisTemplateServiceImpl
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: StringRedisTemplate
 */
@Service
public class StringRedisTemplateServiceImpl extends ARedisOperateImpl<String> {

    private StringRedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }
}
