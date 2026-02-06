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
    @GetMapping("/readyz")
    public ResponseEntity<String> login() {
        // DB check

        // redis check

        return ResponseEntity.ok().body("OK");
    }
}
