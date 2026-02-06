package com.dpt.backend.project.template.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthExceptionType {
    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD("Invalid password", HttpStatus.UNAUTHORIZED);

    private final String message;
    private final HttpStatus statusCode;
}