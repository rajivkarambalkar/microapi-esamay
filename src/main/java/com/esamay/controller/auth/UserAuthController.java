package com.esamay.controller.auth;

import com.esamay.domain.User;
import com.esamay.service.UserServiceBoundary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    private final UserServiceBoundary userServiceApp;

    public UserAuthController(UserServiceBoundary userServiceApp) {
        this.userServiceApp = userServiceApp;
    }

    @PostMapping
    public User authenticateUser(@RequestBody UserLogin user) {
        return userServiceApp.validateUser(user.getEmail(), user.getPassword());
    }
}

