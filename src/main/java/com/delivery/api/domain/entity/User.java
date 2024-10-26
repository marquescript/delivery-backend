package com.delivery.api.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String cpf;
    private List<UserRole> userRoles = new ArrayList<>();

    public User(){}

    public User(Long id, String name, String email, String password, String phoneNumber, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
    }

    public void addUserRole(UserRole userRole){
        this.userRoles.add(userRole);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

}
