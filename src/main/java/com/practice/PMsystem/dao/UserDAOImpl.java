package com.practice.PMsystem.dao;

import com.practice.PMsystem.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotationUserService
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotation
    public void deleteUserById(int id) {
        User tempUser = findUserById(id);

        // remove User and associated Role. This should work because we have cascade type All
        entityManager.remove(tempUser);
    }

    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotation
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        // create query
        TypedQuery<User> query = entityManager.createQuery("SELECT * FROM user", User.class);
        return query.getResultList();
    }

//    @Override
//    public List<User> findAllByOrderByIdAsc() {
//
//        List<User> listOfUsers = retrievingListOfUsers();
//        listOfUsers.sort(Comparator.comparing(User::getId)); // this should make listOfRoles in Order of id
//
//        return listOfUsers;
//    }
//
//    @Override
//    public List<User> findAllByOrderByUsernameAsc() {
//
//        List<User> listOfUsers = retrievingListOfUsers();
//        listOfUsers.sort(Comparator.comparing(User::getUsername)); // this should make listOfRoles in Order of username
//
//        return listOfUsers;
//    }
//
//    @Override
//    public List<User> findAllByOrderByEnabledAsc() {
//
//        List<User> listOfUsers = retrievingListOfUsers();
//        listOfUsers.sort(Comparator.comparing(User::getEnabled)); // this should make listOfRoles in Order of enabled
//
//        return listOfUsers;
//    }
}
