package com.example.ecommbackend.controller;

import com.example.ecommbackend.dto.SignupRequest;
import com.example.ecommbackend.entity.ApplicationUser;
import com.example.ecommbackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationUser register(@RequestBody SignupRequest request) {
        return authenticationService.register(request);
    }
}
