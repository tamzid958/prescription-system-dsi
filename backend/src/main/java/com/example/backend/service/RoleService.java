package com.example.backend.service;

import com.example.backend.dto.RoleDto;
import com.example.backend.entity.Role;
import com.example.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role addNewRole(RoleDto roleDto){
        Role role = new Role();
        role.setName(roleDto.getRole());
        return roleRepository.save(role);
    }
    public Optional<Role> getRoleByName(String role){
        return roleRepository.findRoleByName(role);
    }
}
