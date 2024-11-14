package com.example.ecommbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "store", schema = "fsweb")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Store name cannot be empty")
    @Size(min = 3, message = "Store name should have at least 3 characters")
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "^\\+90\\d{10}$", message = "Phone number must be a valid Türkiye phone number")
    @Column(name = "phone")
    private String phone;

    @Pattern(regexp = "^T\\d{4}V\\d{6}$", message = "Tax number must match the pattern TXXXXVXXXXXX")
    @Column(name = "tax_no")
    private String taxNo;

    @Pattern(regexp = "^(TR\\d{2}[A-Z]{4}\\d{16})$", message = "Bank account must be a valid IBAN")
    @Column(name = "bank_account")
    private String bankAccount;
}
