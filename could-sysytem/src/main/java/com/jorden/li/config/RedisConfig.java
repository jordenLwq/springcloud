package com.jorden.li.config;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * **************************************************************** Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
 * http://jordenlwq.github.io/ Package: com.jorden.li.config Filename: RedisConfig.java Description: TODO(用一句话描述该文件做什么)
 * Copyright: Copyright (c) 2001-2014 Company: Digital Telemedia Co.,Ltd
 * 
 * @author: jorden.li
 * @version: 1.0.0 Create at: 2017年12月27日 上午10:25:22 Revision: redis配置 2017年12月27日 上午10:25:22 - first revision
 */
@Configuration
// 启用缓存，这个注解很重要；
@EnableCaching
public class RedisConfig  extends CachingConfigurerSupport{
    
    @Bean
    @ConditionalOnMissingBean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> Arrays.stream(params).map(Objects::toString).collect(Collectors.joining("_"));
    }
    
    /**

     * 缓存管理器.

     * @param redisTemplate

     * @return

     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {

       CacheManager cacheManager = new RedisCacheManager(redisTemplate);

       return cacheManager;

    }

    /**
     * redis模板操作类,类似于jdbcTemplate的一个类; 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
     * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们 自己的缓存类，比如：RedisStorage类;
     *
     * @param factory
     *            : 通过Spring进行注入，参数在application.properties进行配置；
     * @return
     */

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer((Object.class));
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;

    }
}
