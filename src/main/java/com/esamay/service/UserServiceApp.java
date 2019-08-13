package com.esamay.service;

import com.esamay.domain.User;
import com.esamay.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceApp implements UserServiceBoundary {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceApp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return mapEntitytoUser(userRepository.saveAndFlush(mapUsertoEntity(user)));
    }

    @Override
    public User updateUser(User user) {
        return mapEntitytoUser(userRepository.saveAndFlush(mapUsertoEntity(user)));
    }

    @Override
    public User getUser(String userId) {
        return mapEntitytoUser(userRepository.getOne(userId));
    }

    @Override
    public List<User> getUsers() {
        return mapUsers(userRepository.findAll());
    }

    @Override
    public boolean isRegistered(String email) {
        com.esamay.entity.User user = this.userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public User validateUser(String email, String password) {
        return mapEntitytoUser(this.userRepository.findByEmailAndPassword(email, password));
    }

    private com.esamay.entity.User mapUsertoEntity(User user) {
        ModelMapper mapper = new ModelMapper();
        Type type = new TypeToken<com.esamay.entity.User>() {
        }.getType();
        return mapper.map(user, type);
    }

    private User mapEntitytoUser(com.esamay.entity.User user) {
        if (user == null) {
            return null;
        }
        ModelMapper mapper = new ModelMapper();
        Type type = new TypeToken<User>() {
        }.getType();
        return mapper.map(user, type);
    }

    private List<User> mapUsers(List<com.esamay.entity.User> users) {
        ModelMapper mapper = new ModelMapper();
        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();
        return mapper.map(users, listType);
    }
}
