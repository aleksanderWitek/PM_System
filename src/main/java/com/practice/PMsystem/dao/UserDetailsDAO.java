package com.practice.PMsystem.dao;

import com.practice.PMsystem.entity.User;
import com.practice.PMsystem.entity.UserDetails;

import java.util.List;

public interface UserDetailsDAO {

    void saveUserDetails(UserDetails userDetails);

    void deleteUserDetailsById(int id);

    void updateUserDetails(UserDetails userDetails);

    UserDetails findUserDetailsById(int id);

    // ************************************************
    // is it better to get list of entity's from db and
    // then put them in what order we want or take it already in order from db???
    // ************************************************

    List<UserDetails> findAll();
}
