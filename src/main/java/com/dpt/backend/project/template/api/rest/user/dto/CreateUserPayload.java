package com.dpt.backend.project.template.api.rest.user.dto;

import lombok.Data;

@Data
public class CreateUserPayload {
    private String username;
    private String password;
    private String name;
    private String email;
}