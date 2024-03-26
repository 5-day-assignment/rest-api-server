package com.assignment5d.restapiserver.delegate;

import com.assignment5d.restapiserver.api.DefaultApiDelegate;
import com.assignment5d.restapiserver.dto.UserDto;
import com.assignment5d.restapiserver.entity.NewUser;
import com.assignment5d.restapiserver.entity.UpdateUser;
import com.assignment5d.restapiserver.entity.User;
import com.assignment5d.restapiserver.entity.UserEntity;
import com.assignment5d.restapiserver.service.UserService;
import com.assignment5d.restapiserver.util.StringUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DefaultApiDelegateImpl implements DefaultApiDelegate {

    private final UserService userService;

    public DefaultApiDelegateImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll().stream()
                .map(this::convertToUser)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> findById(UUID userId) {
        UserEntity userEntity = userService.findById(userId);
        User user = convertToUser(userEntity);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> saveNew(NewUser newUser) {
        UserDto userDto = convertToDto(newUser);
        UserEntity savedUserEntity = userService.saveNew(userDto);
        User savedUser = convertToUser(savedUserEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @Override
    public ResponseEntity<User> saveById(UUID userId, UpdateUser updateUser) {
        UserDto userDto = convertToDto(updateUser);
        UserEntity updatedUserEntity = userService.saveById(userId, userDto);
        User updatedUser = convertToUser(updatedUserEntity);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    private User convertToUser(UserEntity userEntity) {
        User user = new User();

        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setGivenName(userEntity.getGivenName());
        user.setFamilyName(userEntity.getFamilyName());
        user.setAddress(userEntity.getAddress());

        return user;
    }


    private UserDto convertToDto(NewUser newUser) {
        UserDto userDto = new UserDto();

        userDto.setUsername(newUser.getUsername());
        userDto.setPassword(newUser.getPassword());
        userDto.setGivenName(newUser.getGivenName());
        userDto.setFamilyName(newUser.getFamilyName());
        userDto.setAddress(newUser.getAddress());

        return userDto;
    }


    private UserDto convertToDto(UpdateUser updateUser) {
        UserDto userDto = new UserDto();

        if (StringUtil.isValid(updateUser.getUsername()))
            userDto.setUsername(updateUser.getUsername());
        if (StringUtil.isValid(updateUser.getPassword()))
            userDto.setPassword(updateUser.getPassword());
        if (StringUtil.isValid(updateUser.getGivenName()))
            userDto.setGivenName(updateUser.getGivenName());
        if (StringUtil.isValid(updateUser.getFamilyName()))
            userDto.setFamilyName(updateUser.getFamilyName());
        if (StringUtil.isValid(updateUser.getAddress()))
            userDto.setAddress(updateUser.getAddress());

        return userDto;
    }

}
