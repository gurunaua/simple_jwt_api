package com.example.jwt.demo.controller;

import com.example.jwt.demo.security.services.UserPrinciple;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestRests {

    @GetMapping("/api/test/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess(Principal principal) {
        System.out.println(principal.getName());
        return ">>> User Contents!";
    }

    @GetMapping("/api/test/pm")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public String projectManagementAccess() {
        return ">>> Board Management Project";
    }

    @GetMapping("/api/test/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }

    @GetMapping("/api/free/free")
    public String freeAccess() {
        return ">>> Free Contents";
    }

    @GetMapping("/api/test/test")
    @PreAuthorize("hasRole('TEST')")
    public String testAccess(UserPrinciple userDetails) {
        return ">>> Test Contents";

    }
}
