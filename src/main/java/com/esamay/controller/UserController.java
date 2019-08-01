package com.esamay.controller;

import com.esamay.domain.User;
import com.esamay.service.UserServiceBoundary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceBoundary userServiceApp;

    public UserController(UserServiceBoundary userServiceApp) {
        this.userServiceApp = userServiceApp;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable(name = "userId") String userId) {
        return userServiceApp.getUser(userId);
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userServiceApp.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userServiceApp.saveUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userServiceApp.updateUser(user);
    }

}
