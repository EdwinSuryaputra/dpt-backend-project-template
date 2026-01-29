package com.dpt.backend.project.template.core.port.out.user;

import com.dpt.backend.project.template.core.domain.user.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}
