package com.dpt.backend.project.template.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
//@RequiredArgsConstructor
public class AuthException extends RuntimeException{
    private final AuthExceptionType type;
    private final HttpStatus statusCode;

    public AuthException(AuthExceptionType type) {
        super(type.getMessage());
        this.type = type;
        this.statusCode = type.getStatusCode();
    }
}