package com.example.reactdemoapp;

import com.example.reactdemoapp.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    public UserEntity findUserByEmail(String email);
}
