package com.dpt.backend.project.template.adapter.inbound.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authn")
@RequiredArgsConstructor
public class UserRestController {
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String payload) {
//        LoginResult result;
//        switch (payload.getType()) {
//            case "credential" -> {
//                LoginPayload.Credential creds = objectMapper.convertValue(payload.getData(), LoginPayload.Credential.class);
//                return ResponseEntity.ok(authnService.loginByCredential(creds.getUsername(), creds.getPassword()));
//            }
//
//
//            default -> throw new IllegalArgumentException("Unsupported login type: " + payload.getType());
//        }
        return null;
    }
}
