package com.example.backend.controller;

import com.example.backend.dto.RoleDto;
import com.example.backend.entity.Role;
import com.example.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> addNewRole(@RequestBody RoleDto roleDto){
        Role role = roleService.addNewRole(roleDto);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }
    @GetMapping("/{role}")
    public ResponseEntity<Role> getRoleByName(@PathVariable String role){
        Role userRole = roleService.getRoleByName(role).orElseThrow(()-> new NoSuchElementException(role + " is not a valid role."));
        return ResponseEntity.ok(userRole);
    }
}
