package com.dpt.backend.project.template.core.port.out;

import java.util.Optional;

public interface CacheStore {
    void save(String key, String value);

    Optional<String> get(String key);

    void delete(String key);
}
