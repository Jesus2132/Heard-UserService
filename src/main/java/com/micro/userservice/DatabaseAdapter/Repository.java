package com.micro.userservice.DatabaseAdapter;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.UserSchema;

public interface Repository extends MongoRepository<UserSchema, String> {
    Optional<UserSchema> findByEmail(String email);
}