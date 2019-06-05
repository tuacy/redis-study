package com.tuacy.redis.study.service.impl;

import com.tuacy.redis.study.service.IRedisOperate;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @name: ARedisOperateImpl
 * @author: tuacy.
 * @date: 2019/6/5.
 * @version: 1.0
 * @Description:
 */
public abstract class ARedisOperateImpl<V> implements IRedisOperate<V> {

    /**
     * 获取对应的RedisTemplate
     *
     * @return RedisTemplate<String, V>
     */
    protected abstract RedisTemplate<String, V> getRedisTemplate();

    private void checkRedisTemplate() {
        if (getRedisTemplate() == null) {
            throw new NullPointerException("RedisTemplate为null!");
        }
    }

    @Override
    public V get(String key) {

        RedisTemplate<String, V> redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            throw new NullPointerException("RedisTemplate 为null");
        }

        return null;
    }

    @Override
    public boolean set(String key, V value) {
        return false;
    }

    @Override
    public boolean set(String key, Object value, long expireTime) {
        return false;
    }

    @Override
    public long incr(String key, long delta) {
        return 0;
    }

    @Override
    public long decr(String key, long delta) {
        return 0;
    }

    @Override
    public Map<String, V> hmget(String key) {
        return null;
    }

    @Override
    public V hget(String key, String mapKey) {
        return null;
    }

    @Override
    public boolean hmset(String key, Map<String, V> map) {
        return false;
    }

    @Override
    public boolean hmset(String key, Map<String, V> map, long expireTime) {
        return false;
    }

    @Override
    public boolean hset(String key, String mapKey, V mapValue) {
        return false;
    }

    @Override
    public boolean hset(String key, String mapKey, V mapValue, long expireTime) {
        return false;
    }

    @Override
    public void hdel(String key, String... mapKey) {

    }

    @Override
    public boolean hHasKey(String key, String mapKey) {
        return false;
    }

    @Override
    public double hincr(String key, String mapKey, double delta) {
        return 0;
    }

    @Override
    public double hdecr(String key, String mapKey, double delta) {
        return 0;
    }

    @Override
    public Set<V> sGet(String key) {
        return null;
    }

    @Override
    public boolean sHasKey(String key, V setItemValue) {
        return false;
    }

    @Override
    public long sSet(String key, V... setValues) {
        return 0;
    }

    @Override
    public long sSet(String key, long time, Object... setValues) {
        return 0;
    }

    @Override
    public long sGetSetSize(String key) {
        return 0;
    }

    @Override
    public long setRemove(String key, Object... setValues) {
        return 0;
    }

    @Override
    public List<V> lGet(String key, long start, long end) {
        return null;
    }

    @Override
    public long lGetListSize(String key) {
        return 0;
    }

    @Override
    public V lGetIndex(String key, long index) {
        return null;
    }

    @Override
    public boolean lSet(String key, V listItemValue) {
        return false;
    }

    @Override
    public boolean lSet(String key, V listItemValue, long expireTime) {
        return false;
    }

    @Override
    public boolean lSet(String key, List<V> listValue) {
        return false;
    }

    @Override
    public boolean lSet(String key, List<V> listValue, long expireTime) {
        return false;
    }

    @Override
    public boolean lUpdateIndex(String key, long index, V listItemValue) {
        return false;
    }

    @Override
    public long lRemove(String key, long count, V listItemValue) {
        return 0;
    }

    @Override
    public boolean expire(String key, long expireTime) {
        return false;
    }

    @Override
    public long getExpire(String key) {
        return 0;
    }

    @Override
    public boolean hasKey(String key) {
        return false;
    }

    @Override
    public void del(String... key) {

    }
}
