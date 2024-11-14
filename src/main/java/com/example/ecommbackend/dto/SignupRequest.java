package com.example.ecommbackend.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String password;
    private Long roleId;
    private StoreRequest store;
}
