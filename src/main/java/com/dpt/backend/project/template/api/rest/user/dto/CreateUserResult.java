package com.dpt.backend.project.template.api.rest.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResult {
    private String publicId;
    private String username;
    private String name;
}
