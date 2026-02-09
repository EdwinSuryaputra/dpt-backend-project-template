package com.dpt.backend.project.template.api.rest.check.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadyzResponse {
    private String sql;
    private String redis;
}
