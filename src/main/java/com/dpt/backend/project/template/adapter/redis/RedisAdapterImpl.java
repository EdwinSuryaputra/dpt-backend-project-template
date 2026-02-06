package com.dpt.backend.project.template.adapter.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisAdapterImpl implements RedisAdapter {
    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void setValue(String key, String value, Long durationInSeconds) {
        redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(durationInSeconds));
    }

    @Override
    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void deleteKeys(List<String> keys) {
        redisTemplate.delete(keys);
    }
}
