package com.practice.PMsystem.services;

import com.practice.PMsystem.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void deleteUserById(int id);

    void updateUser(User user);

    User findUserById(int id);

    List<User> findAllByOrderByIdAsc();

    List<User> findAllByOrderByUsernameAsc();

    List<User> findAllByOrderByEnabledAsc();
}
