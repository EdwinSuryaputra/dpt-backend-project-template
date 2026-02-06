package com.dpt.backend.project.template.adapter.redis;

import java.util.List;

public interface RedisAdapter {
    void setValue(String key, String value, Long durationInSeconds);

    String getValue(String key);

    void deleteKeys(List<String> keys);
}
