package com.shortUrl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisService {

    private final Jedis jedis;

    @Autowired
    public RedisService(Jedis jedis) {
        this.jedis = jedis;
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public void save(String key, String value) {
        jedis.set(key, value);
    }

    public void delete(String key) {
        jedis.del(key);
    }

    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
