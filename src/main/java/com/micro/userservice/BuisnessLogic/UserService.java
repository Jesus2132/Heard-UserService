package com.micro.userservice.BuisnessLogic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.userservice.DatabaseAdapter.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import models.UserSchema;

@Service
public class UserService {
    private final Repository repo;

    @Autowired
    public UserService(Repository repo) {
        this.repo = repo;
    }

    public UserSchema createUser(String username, String email, String profileImageUrl, String bio) {
        UserSchema user = new UserSchema();
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setEmail(email);
        user.setProfileImageUrl(profileImageUrl);
        user.setBio(bio);
        user.setCreatedAt(new Date());
        user.setLastActive(new Date());

        return repo.save(user);
    }

    public List<UserSchema> getAllUsers() {
        return repo.findAll();
    }

    public UserSchema getByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}
