package com.dpt.backend.project.template.api.rest.user;

import com.dpt.backend.project.template.api.rest.user.dto.CreateUserPayload;
import com.dpt.backend.project.template.api.rest.user.dto.CreateUserResult;
import com.dpt.backend.project.template.api.rest.user.dto.UpdateUserPayload;
import com.dpt.backend.project.template.domain.user.model.User;
import com.dpt.backend.project.template.domain.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<Page<User>> getPaginated(@RequestParam(required = false) String filterQuery, Pageable pageable) {
        Page<User> result = userService.getPaginatedUsers(filterQuery, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        User result = userService.getUserDetail(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    public ResponseEntity<CreateUserResult> create(@RequestBody CreateUserPayload payload) {
        User newUser = User.builder()
                .username(payload.getUsername())
                .password(payload.getPassword()) // Note: Should be hashed but service currently takes raw
                .fullName(payload.getName())
                .email(payload.getEmail())
                .createdBy("system") // Placeholder
                .updatedBy("system") // Placeholder
                .createdAt(new java.util.Date())
                .updatedAt(new java.util.Date())
                .build();

        User insertedUser = userService.createUser(newUser);

        CreateUserResult response = CreateUserResult.builder()
                .publicId(insertedUser.getPublicId())
                .name(insertedUser.getFullName())
                .username(insertedUser.getUsername())
                .build();

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UpdateUserPayload payload) {
        User existingUser = userService.getUserDetail(id);
        
        // Update fields
        if (payload.getName() != null) existingUser.setFullName(payload.getName());
        if (payload.getEmail() != null) existingUser.setEmail(payload.getEmail());
        
        existingUser.setUpdatedBy("system"); // Placeholder
        existingUser.setUpdatedAt(new java.util.Date());
        
        User updatedUser = userService.updateUser(existingUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id, "system"); // Placeholder
        return ResponseEntity.noContent().build();
    }
}
