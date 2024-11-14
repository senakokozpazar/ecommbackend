package com.example.ecommbackend.service;

import com.example.ecommbackend.dto.SignupRequest;
import com.example.ecommbackend.dto.StoreRequest;
import com.example.ecommbackend.entity.ApplicationUser;
import com.example.ecommbackend.entity.Role;
import com.example.ecommbackend.entity.Store;
import com.example.ecommbackend.exception.EcommException;
import com.example.ecommbackend.repository.RoleRepository;
import com.example.ecommbackend.repository.StoreRepository;
import com.example.ecommbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private StoreRepository storeRepository;  // Add Store repository

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder, StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.storeRepository = storeRepository;
    }

    public ApplicationUser register(SignupRequest request) {

        String encodedPassword = passwordEncoder.encode(request.getPassword());


        Role userRole = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new EcommException("Role not found", HttpStatus.NOT_FOUND));


        Set<Role> roles = new HashSet<>();
        roles.add(userRole);


        ApplicationUser user = new ApplicationUser();
        user.setFullName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encodedPassword);
        user.setAuthorities(roles);


        if (request.getStore() != null) {
            StoreRequest storeRequest = request.getStore();
            Store store = new Store();
            store.setName(storeRequest.getName());
            store.setPhone(storeRequest.getPhone());
            store.setTaxNo(storeRequest.getTaxNo());
            store.setBankAccount(storeRequest.getBankAccount());


            store = storeRepository.save(store);


            user.setStore(store);
        }


        return userRepository.save(user);
    }
}
