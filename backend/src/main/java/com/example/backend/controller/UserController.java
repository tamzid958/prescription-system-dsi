package com.example.backend.controller;

import com.example.backend.dto.CreateUserDto;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody CreateUserDto dto){
        return new ResponseEntity<>(userService.addNewUser(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<User>> getUsers(Pageable pageable, Sort sort){
        Pageable paginationCriteria = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return ResponseEntity.ok(userService.getUsers(pageable));
    }
}
