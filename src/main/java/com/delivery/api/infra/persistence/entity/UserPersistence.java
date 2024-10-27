package com.delivery.api.infra.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String cpf;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(mappedBy = "userPersistences")
    private List<RestaurantPersistence> restaurantPersistences = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "user_user_type", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_type_id"))
    List<UserRolePersistence> userRolePersistences = new ArrayList<>();

    public UserPersistence(Long id, String name, String email, String password, String cpf, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
    }

    public void addRestaurantPersistence(RestaurantPersistence restaurantPersistence) {
        this.restaurantPersistences.add(restaurantPersistence);
    }

    public void addUserRolePersistence(UserRolePersistence userRolePersistence) {
        this.userRolePersistences.add(userRolePersistence);
    }

    public UserPersistence() {}

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<RestaurantPersistence> getRestaurantPersistences() {
        return restaurantPersistences;
    }

    public List<UserRolePersistence> getUserRolePersistences() {
        return userRolePersistences;
    }

}
