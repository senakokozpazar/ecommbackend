package com.example.ecommbackend.repository;

import com.example.ecommbackend.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
