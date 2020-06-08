package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}