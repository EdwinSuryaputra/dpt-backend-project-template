package com.dpt.backend.project.template.domain.user.service;

import com.dpt.backend.project.template.domain.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Page<User> getPaginatedUsers(String filterQuery, Pageable pageable);

    User getUserDetail(Long userId);

    User createUser(User payload);

    User updateUser(User payload);

    void deleteUser(Long userId, String modifier);
}
