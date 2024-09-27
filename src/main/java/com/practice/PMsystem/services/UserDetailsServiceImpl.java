package com.practice.PMsystem.services;

import com.practice.PMsystem.dao.UserDetailsDAO;
import com.practice.PMsystem.entity.UserDetails;

import java.util.Comparator;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserDetailsDAO userDetailsDAO;

    public UserDetailsServiceImpl(UserDetailsDAO userDetailsDAO) {
        this.userDetailsDAO = userDetailsDAO;
    }

    @Override
    public void saveUserDetails(UserDetails userDetails) {
        this.userDetailsDAO.saveUserDetails(userDetails);
    }

    @Override
    public void deleteUserDetailsById(int id) {
        this.userDetailsDAO.deleteUserDetailsById(id);
    }

    @Override
    public void updateUserDetails(UserDetails userDetails) {
        this.userDetailsDAO.updateUserDetails(userDetails);
    }

    @Override
    public UserDetails findUserDetailsById(int id) {
        return this.userDetailsDAO.findUserDetailsById(id);
    }

    @Override
    public List<UserDetails> findAllByOrderByIdAsc() {
        List<UserDetails> listOfUserDetails = this.userDetailsDAO.findAll();
        listOfUserDetails.sort(Comparator.comparing(UserDetails::getId));


        return listOfUserDetails;
    }

    @Override
    public List<UserDetails> findAllByOrderByLastNameAsc() {
        List<UserDetails> listOfUserDetails = this.userDetailsDAO.findAll();
        listOfUserDetails.sort(Comparator.comparing(UserDetails::getLastName));

        return listOfUserDetails;
    }

    @Override
    public List<UserDetails> findAllByOrderByBranchCountryAsc() {
        List<UserDetails> listOfUserDetails = this.userDetailsDAO.findAll();
        listOfUserDetails.sort(Comparator.comparing(UserDetails::getBranchCountry));

        return listOfUserDetails;
    }
}
