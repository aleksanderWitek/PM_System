package com.practice.PMsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Some Big Problem if ID is null")
    @Column(name = "id")
    private int id;

    @NotNull(message = "Enter user First Name")
    @Size(min = 4, max = 20, message = "First name has to be between 4-20 chars")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Enter user Last Name")
    @Size(min = 4, max = 20, message = "Last name has to be between 4-20 chars")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Enter user email")
    @Size(max = 30, message = "email has to have max 30 chars")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "/^[0123456789]$/", message = "You can only use numbers")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Size(max = 30, message = "Country has to have max 30 chars")
    @Column(name = "branch_country")
    private String branchCountry;

    @Size(max = 30, message = "City has to have max 30 chars")
    @Column(name = "branch_city")
    private String branchCity;

    @OneToOne(cascade = CascadeType.ALL,
              mappedBy = "userDetails")
    private User user;

    public UserDetails() {
    }

    public UserDetails(String firstName, String lastName, String email, String phoneNumber, String branchCountry, String branchCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.branchCountry = branchCountry;
        this.branchCity = branchCity;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBranchCountry() {
        return branchCountry;
    }

    public void setBranchCountry(String branchCountry) {
        this.branchCountry = branchCountry;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
