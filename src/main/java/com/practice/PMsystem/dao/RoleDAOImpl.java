package com.practice.PMsystem.dao;

import com.practice.PMsystem.entity.Role;

import java.util.List;

public class RoleDAOImpl implements RoleDAO{

    @Override
    public void saveRole(Role role) {

    }

    @Override
    public void deleteRoleById(int Id) {

    }

    @Override
    public void updateRoleById(int Id) {

    }

    @Override
    public Role findRoleById(int Id) {
        return null;
    }

    @Override
    public List<Role> findAllByOrderByIdAsc() {
        return List.of();
    }

    @Override
    public List<Role> findAllByOrderByNameAsc() {
        return List.of();
    }
}
