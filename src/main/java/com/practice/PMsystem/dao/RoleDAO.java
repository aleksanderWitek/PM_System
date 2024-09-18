package com.practice.PMsystem.dao;

import com.practice.PMsystem.entity.Role;

import java.util.List;

public interface RoleDAO {

    void saveRole(Role role);

    void deleteRoleById(int id);

    void updateRole(Role role);

    Role findRoleById(int id);

    List<Role> findAll();

    // ************************************************
    // is it better to get list of entity's from db and
    // then put them in what order we want or take it already in order from db???
    // ************************************************
}
