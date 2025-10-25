package com.micro.userservice.BuisnessLogic;

import models.UserSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserSchema register(@RequestBody UserSchema user) {
        return service.createUser(user.getUsername(), user.getEmail(), user.getProfileImageUrl(), user.getBio());
    }

    @GetMapping
    public List<UserSchema> allUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{email}")
    public UserSchema getUserByEmail(@PathVariable String email) {
        return service.getByEmail(email);
    }
}
