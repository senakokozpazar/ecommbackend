package com.example.ecommbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class EcommErrorResponse {
    private String message;
    private LocalDateTime timestamp;
    private int status;
}
