package com.tcs.aifriday.campaign.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationFieldFailures(MethodArgumentNotValidException ex) {
        Map<String, String> bindingErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                bindingErrors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(bindingErrors);
    }
}