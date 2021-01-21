package com.sonomixd.user.controllers;

import com.sonomixd.user.dto.UserDto;
import com.sonomixd.user.models.CreateUserRequest;
import com.sonomixd.user.models.CreateUserResponse;
import com.sonomixd.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/status")
    public String status() {
        return "Its working";
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(request, UserDto.class);

        UserDto createdUser = userService.createUser(userDto);

        CreateUserResponse response = mapper.map(createdUser, CreateUserResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
