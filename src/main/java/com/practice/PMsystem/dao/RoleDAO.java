package com.practice.PMsystem.dao;

import com.practice.PMsystem.entity.Role;

import java.util.List;

public interface RoleDAO {

    void saveRole(Role role);

    void deleteRoleById(int Id);

    void updateRoleById(int Id);

    Role findRoleById(int Id);

    List<Role> findAllByOrderByIdAsc();

    // ************************************************
    // is it better to get list of entity's from db and
    // then put them in what order we want or take it already in order from db???
    // ************************************************

    List<Role> findAllByOrderByNameAsc();

}
