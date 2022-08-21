package com.example.reactdemoapp.services;

import com.example.reactdemoapp.UserRepository;
import com.example.reactdemoapp.entities.UserEntity;
import com.example.reactdemoapp.models.shared.dtos.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("testPass");
        userEntity.setUserId("IDpblico");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(userEntity, userToReturn);

        return userToReturn;
    }
}
