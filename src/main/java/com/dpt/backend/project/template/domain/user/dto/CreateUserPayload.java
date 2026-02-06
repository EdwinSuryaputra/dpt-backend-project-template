package com.dpt.backend.project.template.domain.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateUserPayload {
    private String username;
    private String email;
    private String fullName;
    private String password;
}
