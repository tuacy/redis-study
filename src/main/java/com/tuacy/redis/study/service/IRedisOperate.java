package com.tuacy.redis.study.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @name: IRedisOperate
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description:
 */
public interface IRedisOperate<V> extends IRedisBasicOperate {

    //============================ Redis数据类型：String 字符串

    /**
     * redis数据类型(String 字符串) 获取数据
     *
     * @param key 键
     * @return 值
     */
    V get(String key);

    /**
     * redis数据类型(String 字符串) 存数据
     *
     * @param key   键
     * @param value 值
     */
    void set(String key, V value);

    /**
     * redis数据类型(String 字符串) 存数据
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间
     */
    void set(String key, V value, long expireTime);

    /**
     * redis数据类型(String 字符串) 递增
     *
     * @param key   键
     * @param delta 递增因子
     * @return 修改之后的值
     */
    long incr(String key, long delta);

    /**
     * redis数据类型(String 字符串) 递减
     *
     * @param key   键
     * @param delta 递减因子
     * @return 修改之后的值
     */
    long decr(String key, long delta);

    //================================Map=================================

    /**
     * redis(HashMap) 获取key对应的Map
     *
     * @param key 键
     * @return Map
     */
    Map<String, V> hmget(String key);

    /**
     * redis(HashMap) 获取key对应的Map里面指定mapKey的值
     *
     * @param key    键
     * @param mapKey Map键
     * @return Map对应的值
     */
    V hget(String key, String mapKey);

    /**
     * redis(HashMap) 设置Map
     *
     * @param key 键
     * @param map Map
     */
    void hmset(String key, Map<String, V> map);

    /**
     * redis(HashMap) 设置Map + 过期时间
     *
     * @param key        键
     * @param map        Map
     * @param expireTime 过期时间(秒)
     */
    void hmset(String key, Map<String, V> map, long expireTime);

    /**
     * redis(HashMap) 设置Map键和值
     *
     * @param key      键
     * @param mapKey   Map键
     * @param mapValue Map值
     */
    void hset(String key, String mapKey, V mapValue);

    /**
     * redis(HashMap) 设置Map键和值 + 过期时间
     *
     * @param key        键
     * @param mapKey     Map键
     * @param mapValue   Map值
     * @param expireTime 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     */
    void hset(String key, String mapKey, V mapValue, long expireTime);


    /**
     * redis(HashMap) 删除Map键对应的值
     *
     * @param key    键
     * @param mapKey Map键
     */
    void hdel(String key, String... mapKey);

    /**
     * redis(HashMap) Map键是否存在
     *
     * @param key    键
     * @param mapKey Map键
     * @return 是否存在
     */
    boolean hHasKey(String key, String mapKey);

    /**
     * redis(HashMap) 对Map里面指定的Key的值做递增操作，如果不存在,就会创建一个并把修改后的值返回
     *
     * @param key    键
     * @param mapKey Map键
     * @param delta  递增因子
     * @return 修改之后的值
     */
    double hincr(String key, String mapKey, double delta);

    /**
     * redis(HashMap) 对Map里面指定的Key的值做递减操作，如果不存在,就会创建一个并把修改后的值返回
     *
     * @param key    键
     * @param mapKey Map键
     * @param delta  递减因子
     * @return 修改之后的值
     */
    double hdecr(String key, String mapKey, double delta);

    //============================set=============================

    /**
     * redis(Set) 获取Set
     *
     * @param key 键
     * @return Set
     */
    Set<V> sGet(String key);

    /**
     * redis(Set) Set里面对应的值是否存在
     *
     * @param key          键
     * @param setItemValue 值
     * @return 是否存在
     */
    boolean sHasKey(String key, V setItemValue);

    /**
     * redis(Set) 将值放到Set里面去
     *
     * @param key       键
     * @param setValues 值可以是多个
     * @return 成功个数
     */
    long sSet(String key, V... setValues);

    /**
     * redis(Set) 将值放到Set里面去 + 过期时间
     *
     * @param key       键
     * @param time      时间(秒)
     * @param setValues 值可以是多个
     * @return 成功个数
     */
    long sSet(String key, long time, Object... setValues);

    /**
     * redis(Set) 获取Set长度
     *
     * @param key 键
     * @return Set长度
     */
    long sGetSetSize(String key);

    /**
     * redis(Set) 移除Set里面的值
     *
     * @param key       键
     * @param setValues 值可以是多个
     * @return 移除的个数
     */
    long setRemove(String key, Object... setValues);

    //===============================list=================================

    /**
     * redis(List) 获取List里面的值
     * 0 到 -1代表所有值
     *
     * @param key   键
     * @param start 开始
     * @param end   结束
     * @return list
     */
    List<V> lGet(String key, long start, long end);

    /**
     * redis(List) 获取List长度
     *
     * @param key 键
     * @return list长度
     */
    long lGetListSize(String key);

    /**
     * redis(List) 获取List指定下标对应的值
     *
     * @param key   键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return 值
     */
    V lGetIndex(String key, long index);

    /**
     * redis(List) 把对应值放到List里面去
     *
     * @param key           键
     * @param listItemValue 值
     * @return 是否成功
     */
    boolean lSet(String key, V listItemValue);

    /**
     * redis(List) 把对应值放到List里面去 + 过期时间
     *
     * @param key           键
     * @param listItemValue 值
     * @param expireTime    时间(秒)
     * @return 是否成功
     */
    boolean lSet(String key, V listItemValue, long expireTime);

    /**
     * redis(List) 把对应值放到List里面去
     *
     * @param key       键
     * @param listValue 值
     * @return 是否成功
     */
    boolean lSet(String key, List<V> listValue);

    /**
     * redis(List) 把对应值放到List里面去 + 过期时间
     *
     * @param key        键
     * @param listValue  值
     * @param expireTime 时间(秒)
     * @return 是否成功
     */
    public boolean lSet(String key, List<V> listValue, long expireTime);

    /**
     * redis(List) 修改list里面某个值
     *
     * @param key           键
     * @param index         索引
     * @param listItemValue 值
     * @return 是否成功
     */
    boolean lUpdateIndex(String key, long index, V listItemValue);

    /**
     * redis(List) 移除list里面N个值为listItemValue的值
     *
     * @param key           键
     * @param count         移除多少个
     * @param listItemValue 值
     * @return 移除的个数
     */
    long lRemove(String key, long count, V listItemValue);
}
