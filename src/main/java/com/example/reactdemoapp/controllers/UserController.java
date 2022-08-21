package com.example.reactdemoapp.controllers;


import com.example.reactdemoapp.models.requests.UserDetailRequestModel;
import com.example.reactdemoapp.models.responses.UserRest;
import com.example.reactdemoapp.models.shared.dtos.UserDto;
import com.example.reactdemoapp.services.UserServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceInterface userService;

    @GetMapping
    public String getUser() {
        return "get user details from Spring";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) {

        UserRest userToReturn = new UserRest();

        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);

        BeanUtils.copyProperties(createdUser, userToReturn);

        return userToReturn;

    }
}