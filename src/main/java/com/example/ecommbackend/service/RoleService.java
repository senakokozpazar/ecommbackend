package com.example.ecommbackend.service;

import com.example.ecommbackend.entity.Role;
import com.example.ecommbackend.exception.EcommException;
import com.example.ecommbackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    public Optional<Role> getRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role updateRole(Role role) {
        if (!roleRepository.existsById(role.getId())) {
            throw new EcommException("Role with this ID does not exist.", HttpStatus.NOT_FOUND);
        }
        return roleRepository.save(role);
    }

    public void deleteRole(Long roleId) {
        if (!roleRepository.existsById(roleId)) {
            throw new EcommException("Role with this ID does not exist.", HttpStatus.NOT_FOUND);
        }
        roleRepository.deleteById(roleId);
    }

    public Optional<Role> getRoleByCode(String code) {
        return roleRepository.findByCode(code);
    }
}
