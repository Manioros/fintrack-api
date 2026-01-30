package com.fintrack.fintrack_api.service;

import com.fintrack.fintrack_api.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    void deleteUser(Long id);
}
