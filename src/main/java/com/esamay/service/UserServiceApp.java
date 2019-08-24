package com.esamay.service;

import com.esamay.domain.User;
import com.esamay.repository.UserRepository;
import com.esamay.service.crypto.EncryptionDecryptionBoundary;
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
    private final EncryptionDecryptionBoundary encryptionDecryptionApp;


    @Autowired
    public UserServiceApp(UserRepository userRepository, EncryptionDecryptionBoundary encryptionDecryptionApp) {
        this.userRepository = userRepository;
        this.encryptionDecryptionApp = encryptionDecryptionApp;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(this.encryptionDecryptionApp.encrypt(user.getPassword()));
        return mapEntitytoUser(userRepository.saveAndFlush(mapUsertoEntity(user)));
    }

    @Override
    public User updateUser(User user) {
        user.setPassword(this.encryptionDecryptionApp.encrypt(user.getPassword()));
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
        return mapEntitytoUser(this.userRepository.findByEmailAndPassword(email, this.encryptionDecryptionApp.encrypt(password)));
    }

    @Override
    public User updatePassword(String email, String password) {
        com.esamay.entity.User user = this.userRepository.findByEmail(email);
        user.setPassword(this.encryptionDecryptionApp.encrypt(password));
        return mapEntitytoUser(this.userRepository.saveAndFlush(user));
    }

    @Override
    public String retrievePassword(String email) {
        com.esamay.entity.User user = this.userRepository.findByEmail(email);
        if (user != null) return this.encryptionDecryptionApp.decrypt(user.getPassword());
        else return "";
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
