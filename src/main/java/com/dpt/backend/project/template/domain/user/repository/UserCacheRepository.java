package com.dpt.backend.project.template.domain.user.repository;

public interface UserCacheRepository {
    void getCachedUserDetail(Long userId);

    void setUserDetailTemporarily(Long userId);
}
