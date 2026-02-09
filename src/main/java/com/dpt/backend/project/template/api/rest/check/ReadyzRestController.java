package com.dpt.backend.project.template.api.rest.check;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
@RequiredArgsConstructor
public class ReadyzRestController {
    private final org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
    private final org.springframework.data.redis.connection.RedisConnectionFactory redisConnectionFactory;

    @GetMapping("/readyz")
    public ResponseEntity<com.dpt.backend.project.template.api.rest.check.dto.ReadyzResponse> readyCheck() {
        String sqlStatus = "OK";
        String redisStatus = "OK";
        boolean healthy = true;

        try {
            jdbcTemplate.execute("SELECT 1");
        } catch (Exception e) {
            sqlStatus = "FAILED";
            healthy = false;
        }

        try {
            redisConnectionFactory.getConnection().ping();
        } catch (Exception e) {
            redisStatus = "FAILED";
            healthy = false;
        }

        com.dpt.backend.project.template.api.rest.check.dto.ReadyzResponse response = 
            com.dpt.backend.project.template.api.rest.check.dto.ReadyzResponse.builder()
                .sql(sqlStatus)
                .redis(redisStatus)
                .build();

        if (healthy) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(503).body(response);
        }
    }
}
