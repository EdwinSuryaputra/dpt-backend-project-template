package com.dpt.backend.project.template.adapter.outbound.redis;

import com.dpt.backend.project.template.core.port.out.CacheStore;

import java.util.Optional;

public class RedisCacheAdapter implements CacheStore {
    @Override
    public void save(String key, String value) {

    }

    @Override
    public Optional<String> get(String key) {
        return Optional.empty();
    }

    @Override
    public void delete(String key) {

    }
}
