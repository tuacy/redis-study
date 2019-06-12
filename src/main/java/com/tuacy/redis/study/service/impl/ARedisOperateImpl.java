package com.tuacy.redis.study.service.impl;

import com.tuacy.redis.study.service.IRedisOperate;
import com.tuacy.redis.study.utils.ConvertUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;


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

    //============================ Redis数据类型：String 字符串

    /**
     * redis数据类型(String 字符串) 获取数据
     *
     * @param key 键
     * @return 值
     */
    @Override
    public V get(String key) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * redis数据类型(String 字符串) 存数据
     *
     * @param key   键
     * @param value 值
     */
    @Override
    public void set(String key, V value) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * redis数据类型(String 字符串) 存数据
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间
     */
    @Override
    public void set(String key, V value, long expireTime) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        if (expireTime > 0) {
            redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
        } else {
            set(key, value);
        }
    }

    /**
     * redis数据类型(String 字符串) 递增
     *
     * @param key   键
     * @param delta 递增因子
     * @return 修改之后的值
     */
    @Override
    public long incr(String key, long delta) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        Long redisIncrement = redisTemplate.opsForValue().increment(key, delta);
        if (redisIncrement == null) {
            throw new IllegalArgumentException("incr()函数异常");
        }
        return redisIncrement;
    }

    /**
     * redis数据类型(String 字符串) 递减
     *
     * @param key   键
     * @param delta 递减因子
     * @return 修改之后的值
     */
    @Override
    public long decr(String key, long delta) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        Long redisIncrement = redisTemplate.opsForValue().increment(key, -delta);
        if (redisIncrement == null) {
            throw new IllegalArgumentException("decr()函数异常");
        }
        return redisIncrement;
    }

    /**
     * redis(HashMap) 获取key对应的Map
     *
     * @param key 键
     * @return Map
     */
    @Override
    public Map<String, V> hmget(String key) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return null;
    }

    /**
     * redis(HashMap) 获取key对应的Map里面指定mapKey的值
     *
     * @param key    键
     * @param mapKey Map键
     * @return Map对应的值
     */
    @Override
    public V hget(String key, String mapKey) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return null;
    }

    /**
     * redis(HashMap) 设置Map
     *
     * @param key 键
     * @param map Map
     */
    @Override
    public void hmset(String key, Map<String, V> map) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * redis(HashMap) 设置Map + 过期时间
     *
     * @param key        键
     * @param map        Map
     * @param expireTime 过期时间(秒)
     */
    @Override
    public void hmset(String key, Map<String, V> map, long expireTime) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        redisTemplate.opsForHash().putAll(key, map);
        if (expireTime > 0) {
            expire(key, expireTime);
        }
    }

    /**
     * redis(HashMap) 设置Map键和值
     *
     * @param key      键
     * @param mapKey   Map键
     * @param mapValue Map值
     */
    @Override
    public void hset(String key, String mapKey, V mapValue) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        redisTemplate.opsForHash().put(key, mapKey, mapValue);
    }

    /**
     * redis(HashMap) 设置Map键和值 + 过期时间
     *
     * @param key        键
     * @param mapKey     Map键
     * @param mapValue   Map值
     * @param expireTime 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     */
    @Override
    public void hset(String key, String mapKey, V mapValue, long expireTime) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        redisTemplate.opsForHash().put(key, mapKey, mapValue);
        if (expireTime > 0) {
            expire(key, expireTime);
        }
    }

    @Override
    public void hdel(String key, String... mapKey) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        redisTemplate.opsForHash().delete(key, ConvertUtil.convert(mapKey));
    }

    @Override
    public boolean hHasKey(String key, String mapKey) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return redisTemplate.opsForHash().hasKey(key, mapKey);
    }

    @Override
    public double hincr(String key, String mapKey, double delta) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return redisTemplate.opsForHash().increment(key, mapKey, delta);
    }

    @Override
    public double hdecr(String key, String mapKey, double delta) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return 0;
    }

    @Override
    public Set<V> sGet(String key) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return null;
    }

    @Override
    public boolean sHasKey(String key, V setItemValue) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return false;
    }

    @Override
    public long sSet(String key, V... setValues) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return 0;
    }

    @Override
    public long sSet(String key, long time, Object... setValues) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return 0;
    }

    @Override
    public long sGetSetSize(String key) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return 0;
    }

    @Override
    public long setRemove(String key, Object... setValues) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return 0;
    }

    @Override
    public List<V> lGet(String key, long start, long end) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return null;
    }

    @Override
    public long lGetListSize(String key) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return 0;
    }

    @Override
    public V lGetIndex(String key, long index) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return null;
    }

    @Override
    public boolean lSet(String key, V listItemValue) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return false;
    }

    @Override
    public boolean lSet(String key, V listItemValue, long expireTime) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return false;
    }

    @Override
    public boolean lSet(String key, List<V> listValue) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return false;
    }

    @Override
    public boolean lSet(String key, List<V> listValue, long expireTime) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return false;
    }

    @Override
    public boolean lUpdateIndex(String key, long index, V listItemValue) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return false;
    }

    @Override
    public long lRemove(String key, long count, V listItemValue) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        return 0;
    }

    /**
     * 设置key失效时间
     *
     * @param key        键
     * @param expireTime 时间(秒)
     * @return 是否设置成功
     */
    @Override
    public boolean expire(String key, long expireTime) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        if (expireTime > 0) {
            Boolean redisResult = redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            return redisResult == null ? false : redisResult;
        } else {
            return false;
        }
    }

    /**
     * 获取key对应的失效时间
     *
     * @param key 键
     * @return 时间(秒) 返回0代表为永久有效
     */
    @Override
    public long getExpire(String key) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        Long redisExpireTime = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return redisExpireTime == null ? 0 : redisExpireTime;
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return 对应key值是否存在
     */
    @Override
    public boolean hasKey(String key) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        Boolean redisHasKey = redisTemplate.hasKey(key);
        return redisHasKey == null ? false : redisHasKey;
    }

    /**
     * 删除key
     *
     * @param key 可以传一个或多个值
     */
    @SuppressWarnings("unchecked")
    @Override
    public void del(String... key) {
        RedisTemplate<String, V> redisTemplate = Optional.of(getRedisTemplate()).get();
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }
}
