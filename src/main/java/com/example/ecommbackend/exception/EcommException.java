package com.example.ecommbackend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EcommException extends RuntimeException{
    private HttpStatus status;

    public EcommException(String message,HttpStatus status){
        super(message);
        this.status = status;
    }
}
