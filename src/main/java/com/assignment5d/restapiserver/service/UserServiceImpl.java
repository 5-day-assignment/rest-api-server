package com.assignment5d.restapiserver.service;

import com.assignment5d.restapiserver.dto.UserDto;
import com.assignment5d.restapiserver.entity.UserEntity;
import com.assignment5d.restapiserver.exception.UserNotFoundException;
import com.assignment5d.restapiserver.repository.UserRepository;
import com.assignment5d.restapiserver.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public UserEntity saveNew(UserDto userDto) {
        UserEntity user = new UserEntity();

        user.setUsername(userDto.getUsername());
        user.setEncryptedPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setGivenName(userDto.getGivenName());
        user.setFamilyName(userDto.getFamilyName());
        user.setAddress(userDto.getAddress());

        return userRepository.save(user);
    }

    @Override
    public UserEntity saveById(UUID id, UserDto userDto) {
        UserEntity user = findById(id);

        if (StringUtil.isValid(userDto.getUsername()))
            user.setUsername(userDto.getUsername());
        if (StringUtil.isValid(userDto.getPassword()))
            user.setEncryptedPassword(passwordEncoder.encode(userDto.getPassword()));
        if (StringUtil.isValid(userDto.getGivenName()))
            user.setGivenName(userDto.getGivenName());
        if (StringUtil.isValid(userDto.getFamilyName()))
            user.setFamilyName(userDto.getFamilyName());
        if (StringUtil.isValid(userDto.getAddress()))
            user.setAddress(userDto.getAddress());

        return userRepository.save(user);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
