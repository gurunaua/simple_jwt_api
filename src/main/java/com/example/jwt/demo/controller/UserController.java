package com.example.jwt.demo.controller;

import com.example.jwt.demo.payload.UserInfo;
import com.example.jwt.demo.security.services.UserPrinciple;
import com.example.jwt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUser(){
        List<UserInfo> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, UserPrinciple userPrinciple){
        UserInfo userInfo = userService.getUserById(id);
        return ResponseEntity.ok(userInfo);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping(value = "/me")
    public ResponseEntity<?> getById(UserPrinciple userPrinciple){
        UserInfo userInfo = userService.getUserByUserName(userPrinciple.getUsername());
        return ResponseEntity.ok(userInfo);
    }

}
