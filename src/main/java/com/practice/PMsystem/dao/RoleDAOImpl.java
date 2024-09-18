package com.practice.PMsystem.dao;

import com.practice.PMsystem.entity.Role;
import com.practice.PMsystem.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO{

    private EntityManager entityManager;

    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotation
    public void saveRole(Role role) {
        this.entityManager.persist(role);
    }

    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotation
    public void deleteRoleById(int id) {

        // retrieve role
        Role tempRole = this.entityManager.find(Role.class, id);

        // remove Role and associated User. This should work because we have cascade type All
        this.entityManager.remove(tempRole);
    }

    @Override
    @Transactional // when we are updating database (save, remove or update) we need this annotation
    public void updateRole(Role role) {
        // this method will update current Role
        this.entityManager.merge(role);
    }

    @Override
    public Role findRoleById(int id) {
        return entityManager.find(Role.class, id);
    }
    @Override
    public List<Role> findAll() {
        // create query
        TypedQuery<Role> query = entityManager.createQuery("SELECT * FROM role", Role.class);
        return query.getResultList();
    }

//    @Override
//    public List<Role> findAllByOrderByIdAsc() {
//
//        List<Role> listOfRoles = retrievingListOfRoles();
//        listOfRoles.sort(Comparator.comparing(Role::getId)); // this should make listOfRoles in Order of id
//
//        return listOfRoles;
//    }
//
//    @Override
//    public List<Role> findAllByOrderByNameAsc() {
//
//        List<Role> listOfRoles = retrievingListOfRoles();
//
//        listOfRoles.sort(Comparator.comparing(Role::getName)); // this should make listOfRoles in Order of name
//
//        return listOfRoles;
//    }
}
