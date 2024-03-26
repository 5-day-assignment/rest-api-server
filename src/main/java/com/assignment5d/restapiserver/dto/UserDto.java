package com.assignment5d.restapiserver.dto;

import com.assignment5d.restapiserver.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String username;

    @ValidPassword
    private String password;

    private String givenName;

    private String familyName;

    private String address;
}
