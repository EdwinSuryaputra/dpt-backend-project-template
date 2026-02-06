package com.dpt.backend.project.template.api.rest.user;

import com.dpt.backend.project.template.api.rest.user.dto.CreateUserPayload;
import com.dpt.backend.project.template.api.rest.user.dto.CreateUserResult;
import com.dpt.backend.project.template.domain.user.model.User;
import com.dpt.backend.project.template.domain.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    @Autowired
    private final UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<String> getPaginated(@Param("filterQuery") String filterQuery, Pageable pageable) {

    }

    @PostMapping("/")
    public ResponseEntity<CreateUserResult> create(@RequestBody CreateUserPayload payload) {
        User newUser = User.builder().build();

        User insertedUser = userService.createUser(newUser);

        CreateUserResult response = CreateUserResult.builder()
                .publicId(insertedUser.getPublicId())
                .name(insertedUser.getFullName())
                .username(insertedUser.getUsername())
                .build();

        return ResponseEntity.ok().body(response);
    }
}
