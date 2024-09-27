package com.practice.PMsystem.services;

import com.practice.PMsystem.entity.User;
import com.practice.PMsystem.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {

    void saveUserDetails(UserDetails userDetails);

    void deleteUserDetailsById(int id);

    void updateUserDetails(UserDetails userDetails);

    UserDetails findUserDetailsById(int id);

    List<UserDetails> findAllByOrderByIdAsc();

    List<UserDetails> findAllByOrderByLastNameAsc();

    List<UserDetails> findAllByOrderByBranchCountryAsc();
}
