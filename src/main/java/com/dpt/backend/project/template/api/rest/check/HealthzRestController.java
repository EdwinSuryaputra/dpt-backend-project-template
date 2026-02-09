package com.dpt.backend.project.template.api.rest.check;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/check")
@RequiredArgsConstructor
public class HealthzRestController {
    @GetMapping("/healthz")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok().body("OK");
    }
}
