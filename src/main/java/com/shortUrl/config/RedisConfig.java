package com.shortUrl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(redisHost, redisPort); // Return JedisPool instance
    }

    @Bean
    public Jedis jedis(JedisPool jedisPool) {
        try (Jedis jedis = jedisPool.getResource()) {  // Use Jedis instance within try-with-resources
            // Check if Redis is reachable
            if ("PONG".equals(jedis.ping())) {
                System.out.println("Connected to Redis successfully.");
            }
            return jedis; // Return the Jedis instance
        } catch (JedisConnectionException e) {
            throw new RuntimeException("Could not connect to Redis, Redis might be down.", e);
        }
    }
}
