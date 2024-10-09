package com.practice.PMsystem.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Some Big Problem if ID is null")
    @Column(name = "id")
    private int id;

    @NotNull(message = "Can't be empty and need to be unique.")
    @Size(min = 4, max = 20, message = "Username has to be between 4-20 chars")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Can't be empty.")
    @Size(min = 4, max = 20, message = "Password has to be between 4-20 chars")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Can't be empty.")
    @Pattern(regexp = "/^[01]$/", message = "You need to put number 1 or 0 only. 1 for active user and 0 for not active user.")
    @Size(min = 1, max = 1, message = "You need to put number 1 or 0 only. 1 for active user and 0 for not active user.")
    @Column(name = "enabled")
    private int enabled;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role userRole;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    public User() {
    }

    public User(String username, String password, int enabled, Role uRole) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userRole = uRole;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", userRole=" + userRole +
                '}';
    }

    // convenience method
    public void add(Role tempRole){

        tempRole.add(this);

        this.setUserRole(tempRole);
    }
}
