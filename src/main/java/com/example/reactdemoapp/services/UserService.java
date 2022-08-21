package com.example.reactdemoapp.services;

import com.example.reactdemoapp.models.shared.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{
    @Override
    public UserDto createUser(UserDto user) {
        return null;
    }
}
