package com.example.ecommbackend.dto;

import lombok.Data;

@Data
public class StoreRequest {
    private String name;
    private String phone;
    private String taxNo;
    private String bankAccount;
}
