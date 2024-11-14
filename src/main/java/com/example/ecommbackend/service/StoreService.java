package com.example.ecommbackend.service;

import com.example.ecommbackend.dto.StoreRequest;
import com.example.ecommbackend.entity.Store;
import com.example.ecommbackend.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;


    public Store createStore(StoreRequest storeRequest) {
        Store store = new Store();
        store.setName(storeRequest.getName());
        store.setPhone(storeRequest.getPhone());
        store.setTaxNo(storeRequest.getTaxNo());
        store.setBankAccount(storeRequest.getBankAccount());
        return storeRepository.save(store);
    }
}
