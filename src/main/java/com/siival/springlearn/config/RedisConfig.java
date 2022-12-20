package com.siival.springlearn.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@Configuration
public class RedisConfig {
	

	/**
     *  设置 redis 数据默认过期时间 
     *  设置@cacheable 序列化方式
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
    	ObjectMapper om = new ObjectMapper();
    	//增加jdk8 local date time序列化支持
    	om = om.registerModule(new JavaTimeModule());
    	om = om.activateDefaultTyping(om.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(om);
        //序列化key
        configuration = configuration.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
        // 序列化value
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer)).entryTtl(Duration.ofHours(2L)) ;
        return configuration;
    }
}
