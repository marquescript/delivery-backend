package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.enums.UserRoleEnum;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_role")
public class UserRolePersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_enum")
    private UserRoleEnum userRoleEnum;

    @ManyToMany(mappedBy = "userRolePersistences")
    List<UserPersistence> userPersistences = new ArrayList<>();

    public UserRolePersistence(Long id, UserRoleEnum userRoleEnum) {
        this.id = id;
        this.userRoleEnum = userRoleEnum;
    }

    public UserRolePersistence() {}

    public void addUserPersistence(UserPersistence userPersistence) {
        this.userPersistences.add(userPersistence);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRoleEnum getUserRoleEnum() {
        return userRoleEnum;
    }

    public void setUserRoleEnum(UserRoleEnum userRoleEnum) {
        this.userRoleEnum = userRoleEnum;
    }

    public List<UserPersistence> getUserPersistences() {
        return userPersistences;
    }

}
