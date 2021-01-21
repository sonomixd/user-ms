package com.sonomixd.user.services.impl;

import com.sonomixd.user.dto.UserDto;
import com.sonomixd.user.entities.UserEntity;
import com.sonomixd.user.repositories.UserRepository;
import com.sonomixd.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        // set a random user id
        userDto.setUserId(UUID.randomUUID().toString());

        // map user dto into user entity
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPassword("test");

        userRepository.save(userEntity);

        return mapper.map(userEntity, UserDto.class);
    }
}
