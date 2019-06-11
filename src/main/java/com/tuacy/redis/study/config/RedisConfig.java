package com.tuacy.redis.study.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.tuacy.redis.study.config.serializer.KryoRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @name: RedisConfig
 * @author: tuacy.
 * @date: 2019/6/4.
 * @version: 1.0
 * @Description: redis相关配置
 */
@Configuration
public class RedisConfig {

    /**
     * 全局手动指定RedisTemplate的Key和Value的序列化器
     */
    //FastJsonRedisSerializer
    @Bean
    public RedisTemplate<String, Object> redisTemplateKeyString(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 使用Jackson2JsonRedisSerializer 替换默认序列化
        FastJsonRedisSerializer<Object> valueSerializer = new FastJsonRedisSerializer<>(Object.class);
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key序列化方式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer()); // hash key序列化方式
        redisTemplate.setValueSerializer(valueSerializer); // 值序列化方式
        redisTemplate.setHashValueSerializer(valueSerializer); // hash value序列化方式
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

//    // KryoRedisSerializer
//    @Bean
//    public RedisTemplate<String, Object> redisTemplateKeyString(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        // 使用KryoRedisSerializer 替换默认序列化
//        KryoRedisSerializer<Object> valueSerializer = new KryoRedisSerializer<>(Object.class);
//        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key序列化方式
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer()); // hash key序列化方式
//        redisTemplate.setValueSerializer(valueSerializer); // 值序列化方式
//        redisTemplate.setHashValueSerializer(valueSerializer); // hash value序列化方式
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }

//    // Jackson2JsonRedisSerializer
//    @Bean
//    public RedisTemplate<String, Object> redisTemplateKeyString(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        // 使用Jackson2JsonRedisSerializer 替换默认序列化
//        Jackson2JsonRedisSerializer<Object> valueSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key序列化方式
//        redisTemplate.setValueSerializer(valueSerializer); // 值序列化方式
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
    // FastJsonRedisSerializer 序列化带泛型的数据时，会以map的结构进行存储，反序列化时候我们不好将map解析成对象。所以我们一般不用这种序列化方式。不好反序列化
//    @Bean
//    public RedisTemplate<String, Object> redisTemplateKeyString(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        // 使用Jackson2JsonRedisSerializer 替换默认序列化
//        Jackson2JsonRedisSerializer<Object> valueSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key序列化方式
//        redisTemplate.setValueSerializer(valueSerializer); // 值序列化方式
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer()); // hash key序列化方式
//        redisTemplate.setHashValueSerializer(valueSerializer); // hash value序列化方式
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }

}
