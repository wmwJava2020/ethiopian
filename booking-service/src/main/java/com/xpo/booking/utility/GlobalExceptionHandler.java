package com.xpo.booking.utility;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * Time: 5:46 PM
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAll(Exception e) {
        e.printStackTrace();   // ← prints full stack trace to IntelliJ console
        return ResponseEntity.status(500).body(Map.of(
                "error",     e.getClass().getSimpleName(),
                "message",   e.getMessage() != null ? e.getMessage() : "NULL MESSAGE",
                "cause",     e.getCause()   != null ? e.getCause().getMessage() : "NO CAUSE",
                "timestamp", LocalDateTime.now().toString()
        ));
    }
}
