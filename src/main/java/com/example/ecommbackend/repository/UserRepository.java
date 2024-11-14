package com.example.ecommbackend.repository;

import com.example.ecommbackend.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {


    Optional<Object> findUserByEmail(String username);

}
