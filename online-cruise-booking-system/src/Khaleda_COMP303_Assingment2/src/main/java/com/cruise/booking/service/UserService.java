package com.cruise.booking.service;

import com.cruise.booking.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    User saveUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    boolean existsByEmail(String email);
}
