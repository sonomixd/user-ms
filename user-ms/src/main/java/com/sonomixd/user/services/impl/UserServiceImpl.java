package com.sonomixd.user.services.impl;

import com.sonomixd.user.dto.UserDto;
import com.sonomixd.user.services.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Override
    public UserDto createUser(UserDto userDto) {

        // set a random user id
        userDto.setId(UUID.randomUUID().toString());
        return null;
    }
}
