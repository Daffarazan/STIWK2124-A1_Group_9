package com.arl.backend.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ErrorResponse {
    private final int status;
    private final List<FieldError> errors;
    private final String path;

    @Getter @AllArgsConstructor
    public static class FieldError {
        private final String field;
        private final String message;
    }
}