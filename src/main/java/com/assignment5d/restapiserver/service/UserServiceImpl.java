package com.assignment5d.restapiserver.service;

import com.assignment5d.restapiserver.dto.UserDto;
import com.assignment5d.restapiserver.entity.UserEntity;
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
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
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

        if (userDto.getUsername() != null && !userDto.getUsername().isEmpty())
            user.setUsername(userDto.getUsername());
        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty())
            user.setEncryptedPassword(passwordEncoder.encode(userDto.getPassword()));
        if (userDto.getGivenName() != null && !userDto.getGivenName().isEmpty())
            user.setGivenName(userDto.getGivenName());
        if (userDto.getFamilyName() != null && !userDto.getFamilyName().isEmpty())
            user.setFamilyName(userDto.getFamilyName());
        if (userDto.getAddress() != null && !userDto.getAddress().isEmpty())
            user.setAddress(userDto.getAddress());

        return userRepository.save(user);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
