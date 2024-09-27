package com.practice.PMsystem.dao;

import com.practice.PMsystem.entity.User;
import com.practice.PMsystem.entity.UserDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO{

    private final EntityManager entityManager;

    public UserDetailsDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotationUserService
    public void saveUserDetails(UserDetails userDetails) {
        entityManager.persist(userDetails);
    }

    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotationUserService
    public void deleteUserDetailsById(int id) {
        UserDetails tempUserDetails = findUserDetailsById(id);

        entityManager.remove(tempUserDetails);
    }

    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotationUserService
    public void updateUserDetails(UserDetails userDetails) {
        entityManager.merge(userDetails);
    }

    @Override
    public UserDetails findUserDetailsById(int id) {
        return entityManager.find(UserDetails.class, id);
    }

    @Override
    public List<UserDetails> findAll() {
        TypedQuery<UserDetails> query = entityManager.createQuery("SELECT * FROM user_details", UserDetails.class);
        return query.getResultList();
    }
}
