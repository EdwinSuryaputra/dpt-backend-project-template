package com.dpt.backend.project.template.adapter.redis.user;

import com.dpt.backend.project.template.adapter.redis.RedisAdapter;
import com.dpt.backend.project.template.domain.user.repository.UserCacheRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserCacheRepositoryImpl implements UserCacheRepository {
    private final RedisAdapter redisAdapter;

    public UserCacheRepositoryImpl(RedisAdapter redisAdapter) {
        this.redisAdapter = redisAdapter;
    }

    public void getCachedUserDetail(Long userId) {
        redisAdapter.getValue("");
    }

    public void setUserDetailTemporarily(Long userId) {
        redisAdapter.setValue("", "", 1000L);
    }
}
