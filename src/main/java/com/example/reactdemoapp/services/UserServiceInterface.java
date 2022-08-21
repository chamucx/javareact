package com.example.reactdemoapp.services;

import com.example.reactdemoapp.models.shared.dtos.UserDto;

public interface UserServiceInterface {
    public UserDto createUser(UserDto user);
}
