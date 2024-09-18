package com.practice.PMsystem.services;

import com.practice.PMsystem.dao.RoleDAO;
import com.practice.PMsystem.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    public void deleteRoleById(int id) {
        roleDAO.deleteRoleById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Override
    public Role findRoleById(int id) {
        return roleDAO.findRoleById(id);
    }

    @Override
    public List<Role> findAllByOrderByIdAsc() {

        List<Role> listOfRoles = roleDAO.findAll();
        listOfRoles.sort(Comparator.comparing(Role::getId)); // this should make listOfRoles in Order of id

        return listOfRoles;
    }

    @Override
    public List<Role> findAllByOrderByNameAsc() {

        List<Role> listOfRoles = roleDAO.findAll();
        listOfRoles.sort(Comparator.comparing(Role::getName));

        return listOfRoles;
    }
}
