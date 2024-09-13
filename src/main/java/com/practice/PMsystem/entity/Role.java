package com.practice.PMsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Some Big Problem if ID is null")
    @Column(name = "id")
    private int id;

    // how to get validation for all positions like: EMPLOYEE, MANAGER, PROJECT_MANAGER, SUPERVISOR, HR, ADMIN, BOSS.
    // I know we can do it later in frontend and controller, but I think it should be a easy way of doing it here with annotations.
    @NotNull(message = "Put Role name from list: EMPLOYEE, MANAGER, PROJECT_MANAGER, SUPERVISOR, HR, ADMIN, BOSS")
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersList;

    public Role(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // convenience method
    public void add(User tempUser){

        if(usersList == null) {
            usersList = new ArrayList<>();
        }

        usersList.add(tempUser);

        tempUser.setUserRole(this);
    }

}
