package com.example.reactdemoapp.controllers;


import com.example.reactdemoapp.models.requests.UserDetailRequestModel;
import com.example.reactdemoapp.models.responses.UserRest;
import com.example.reactdemoapp.models.shared.dtos.UserDto;
import com.example.reactdemoapp.services.UserServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceInterface userService;

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getPrincipal().toString();
        UserDto userDto = userService.getUser(email);
        UserRest userToReturn = new UserRest();

        BeanUtils.copyProperties(userDto, userToReturn);

        return userToReturn;

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