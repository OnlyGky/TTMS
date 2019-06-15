package com.springboot.richttms.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置类
 */
@Configuration
//表示IOC容器启动了缓存机制
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {




    //配置缓存管理器
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                this.getRedisCacheConfigurationWithTtl(600), // 默认策略，未配置的 key 会使用这个
                this.getRedisCacheConfigurationMap() // 指定 key 策略
        );
    }

    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap(){
        Map<String,RedisCacheConfiguration>redisCacheConfigurationMap=new HashMap<>();
        redisCacheConfigurationMap.put("schedule",this.getRedisCacheConfigurationWithTtl(3000));
        return redisCacheConfigurationMap;
    }

    //自定义缓存配置缓存时间和序列化相关配置
    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
        //序列化器
        Jackson2JsonRedisSerializer<Object>jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer<>(Object.class);
        //解决查询缓存转换异常问题
        //使用Jackson2JsonRedisSerialize 替换默认序列化(默认采用的是JDK序列化)
        ObjectMapper om=new ObjectMapper();
//        将通过反射机制直接操作Java对象上的字段。
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //使用 defaultTyping 实现通用的序列化和反序列化
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //配置序列化（解决乱码问题）
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration=redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(jackson2JsonRedisSerializer)
        ).entryTtl(Duration.ofSeconds(seconds));//定义默认的cache time-to-live.
        return redisCacheConfiguration;
    }



}
