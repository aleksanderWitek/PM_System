package com.practice.PMsystem.services;

import com.practice.PMsystem.entity.Role;

import java.util.List;

public interface RoleService {

    void saveRole(Role role);

    void deleteRoleById(int id);

    void updateRole(Role role);

    Role findRoleById(int id);

    List<Role> findAllByOrderByIdAsc();

    List<Role> findAllByOrderByNameAsc();
}
