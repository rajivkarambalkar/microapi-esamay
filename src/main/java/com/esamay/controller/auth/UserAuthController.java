package com.esamay.controller.auth;

import com.esamay.domain.User;
import com.esamay.service.UserServiceBoundary;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public User resetPassword(@RequestBody UserLogin user) {
        return userServiceApp.updatePassword(user.getEmail(), user.getPassword());
    }

    @GetMapping
    public String retrievePassword(@PathVariable(name = "email") String email) {
        return userServiceApp.retrievePassword(email);
    }

}

