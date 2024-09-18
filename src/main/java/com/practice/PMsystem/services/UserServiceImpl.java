package com.practice.PMsystem.services;

import com.practice.PMsystem.dao.UserDAO;
import com.practice.PMsystem.entity.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User findUserById(int id) {
        return userDAO.findUserById(id);
    }

    @Override
    public List<User> findAllByOrderByIdAsc() {

        List<User> listOfUsers = userDAO.findAll();
        listOfUsers.sort(Comparator.comparing(User::getId)); // this should make listOfRoles in Order of id

        return listOfUsers;
    }

    @Override
    public List<User> findAllByOrderByUsernameAsc() {

        List<User> listOfUsers = userDAO.findAll();
        listOfUsers.sort(Comparator.comparing(User::getUsername)); // this should make listOfRoles in Order of username

        return listOfUsers;
    }

    @Override
    public List<User> findAllByOrderByEnabledAsc() {

        List<User> listOfUsers = userDAO.findAll();
        listOfUsers.sort(Comparator.comparing(User::getEnabled)); // this should make listOfRoles in Order of enabled

        return listOfUsers;
    }
}
