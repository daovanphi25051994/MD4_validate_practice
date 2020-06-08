package com.codegym.service;

import com.codegym.model.User;

public interface IUserService {
    User save(User user);
    Iterable<User> getAll();
}
