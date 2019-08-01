package com.esamay.service;

import com.esamay.domain.User;

import java.util.List;

public interface UserServiceBoundary {
    User saveUser(User user);
    User updateUser(User user);
    User getUser(String userId);
    List<User> getUsers();
}
