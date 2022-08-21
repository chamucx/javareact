package com.example.reactdemoapp.services;

import com.example.reactdemoapp.models.shared.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService {
    public UserDto createUser(UserDto user);
}
