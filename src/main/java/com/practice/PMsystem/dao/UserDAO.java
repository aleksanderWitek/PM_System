package com.practice.PMsystem.dao;

import com.practice.PMsystem.entity.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    void deleteUserById(int id);

    void updateUser(User user);

    User findUserById(int id);

    // ************************************************
    // is it better to get list of entity's from db and
    // then put them in what order we want or take it already in order from db???
    // ************************************************

    List<User> findAll();

//    List<User> findAllByOrderByIdAsc();
//
//    List<User> findAllByOrderByUsernameAsc();
//
//    List<User> findAllByOrderByEnabledAsc();
}
