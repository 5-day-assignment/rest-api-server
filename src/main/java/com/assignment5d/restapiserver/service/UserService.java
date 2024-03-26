package com.assignment5d.restapiserver.service;

import com.assignment5d.restapiserver.dto.UserDto;
import com.assignment5d.restapiserver.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserEntity> findAll();

    UserEntity findById(UUID id);

    UserEntity saveNew(UserDto userDto);

    UserEntity saveById(UUID id, UserDto userDto);

    void deleteById(UUID id);
}
