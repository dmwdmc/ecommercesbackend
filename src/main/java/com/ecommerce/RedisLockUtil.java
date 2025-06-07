package com.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLockUtil {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean tryLock(String lockKey, String requestId, long expireTime) {
        return redisTemplate.opsForValue()
                .setIfAbsent(lockKey, requestId, expireTime, TimeUnit.MILLISECONDS);
    }

    public boolean unlock(String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                "return redis.call('del', KEYS[1]) else return 0 end";
        return redisTemplate.execute(
                new DefaultRedisScript<>(script, Long.class),
                Collections.singletonList(lockKey),
                requestId
        ) == 1;
    }
}