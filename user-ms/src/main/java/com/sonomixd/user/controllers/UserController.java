package com.sonomixd.user.controllers;

import com.sonomixd.user.models.CreateUserRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/status")
    public String status() {
        return "Its working";
    }

    @PostMapping("/create")
    public String createUser(@Valid @RequestBody CreateUserRequest request) {
        return "User is created";
    }
}
