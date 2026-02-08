package com.dpt.backend.project.template.service.user;

import com.dpt.backend.project.template.adapter.sql.user.UserJpaRepository;
import com.dpt.backend.project.template.common.exception.AuthException;
import com.dpt.backend.project.template.common.exception.AuthExceptionType;
import com.dpt.backend.project.template.domain.user.model.User;
import com.dpt.backend.project.template.domain.user.repository.UserCacheRepository;
import com.dpt.backend.project.template.domain.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userRepository;
    private final UserCacheRepository userCacheRepository;

    public UserServiceImpl(UserJpaRepository userRepository, UserCacheRepository userCacheRepository) {
        this.userRepository = userRepository;
        this.userCacheRepository = userCacheRepository;
    }

    @Override
    public Page<User> getPaginatedUsers(String filterQuery, Pageable pageable) {
        Page<User> users = userRepository.findAllFullTextPaginated(filterQuery, pageable);
        return users;
    }

    @Override
    public User getUserDetail(Long userId) {
        Optional<User> user = userRepository.findOneById(userId);
        if (user.isEmpty()) throw new AuthException(AuthExceptionType.USER_NOT_FOUND);

        return user.get();
    }

    @Override
    public User createUser(User payload) {
        payload.setPassword(payload.getPassword());
        payload.setPublicId(UUID.randomUUID().toString());

        return userRepository.save(payload);
    }

    @Override
    public User updateUser(User payload) {
        return userRepository.save(payload);
    }

    @Override
    public void deleteUser(Long userId, String modifier) {
        Optional<User> existingUser = userRepository.findOneById(userId);
        if (existingUser.isEmpty()) throw new AuthException(AuthExceptionType.USER_NOT_FOUND);

        existingUser.get().setDeletedAt(Date.from(Instant.now()));
        existingUser.get().setDeletedBy(modifier);

        userRepository.save(existingUser.get());
    }
}
