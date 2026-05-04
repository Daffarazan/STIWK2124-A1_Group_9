package com.arl.backend.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ErrorResponse {
    private int status;
    private List<FieldError> errors;
    private String path;

    @Getter @AllArgsConstructor
    public static class FieldError {
        private String field;
        private String message;
    }
}