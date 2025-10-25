package com.micro.userservice.BuisnessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import models.UserSchema;

@Service
public class UserPublisher {

    @Autowired
    private StreamBridge streamBridge;

    public void publishPrompt(UserSchema user) {
        streamBridge.send("userCreated-out-0", user);
        System.out.println("✅ Published prompt: " + user.getEmail());
    }
}
