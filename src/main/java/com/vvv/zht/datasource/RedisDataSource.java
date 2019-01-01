package com.vvv.zht.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisDataSource extends RedisProperties {
    @Value("${spring.redis.max-total}")
    private int maxTotal;

    @Value("${spring.redis.min-idle}")
    private int minIdle;

    @Value("${spring.redis.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.max-wait-millis}")
    private int maxWaitMillis;

    @Value("${spring.redis.test-while-idle}")
    private boolean testWhileIdle;

    @Value("${spring.redis.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${spring.redis.test-on-return}")
    private boolean testOnReturn;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        return jedisPoolConfig;
    }
    private JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig());
        factory.setHostName(host);
        factory.setPort(port);
        factory.setPassword(password);
        factory.afterPropertiesSet();
        return factory;
    }
    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean(name = "redisTemplate")
    public <K, V> RedisTemplate<K, V> redisTemplate() {
        RedisTemplate<K, V> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(stringRedisSerializer());
        template.setValueSerializer(stringRedisSerializer());
        template.setHashKeySerializer(stringRedisSerializer());
        template.setHashValueSerializer(stringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }
}
