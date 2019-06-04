package com.tuacy.redis.study.param;

/**
 * @name: RedisIntegerSetParam
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: 把对象数据设置到redis里面去
 */
public class RedisObjectSetParam {

    private String redisKey;
    private ObjectParam redisValue;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public ObjectParam getRedisValue() {
        return redisValue;
    }

    public void setRedisValue(ObjectParam redisValue) {
        this.redisValue = redisValue;
    }

    public static class ObjectParam {
        private String userName;
        private int age;
        private String address;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
