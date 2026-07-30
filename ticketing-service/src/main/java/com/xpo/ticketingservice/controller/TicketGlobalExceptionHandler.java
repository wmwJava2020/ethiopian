package com.xpo.ticketingservice.controller;

import com.xpo.ticketingservice.service.TicketException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class TicketGlobalExceptionHandler {

    @ExceptionHandler(TicketException.class)
    public ResponseEntity<Map<String, Object>> handleTicketException(TicketException e) {
        return ResponseEntity.badRequest().body(Map.of(
            "error",     "TicketException",
            "message",   e.getMessage(),
            "timestamp", LocalDateTime.now().toString()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAll(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body(Map.of(
            "error",     e.getClass().getSimpleName(),
            "message",   e.getMessage() != null ? e.getMessage() : "NULL MESSAGE",
            "cause",     e.getCause()   != null ? e.getCause().getMessage() : "NO CAUSE",
            "timestamp", LocalDateTime.now().toString()
        ));
    }
}
