package com.dpt.backend.project.template.api.rest.user.dto;

import lombok.Data;

@Data
public class UpdateUserPayload {
    private String name;
    private String email;
}
