package com.delivery.api.application.service;

import com.delivery.api.domain.entity.User;
import com.delivery.api.domain.exception.CpfAlreadyRegistered;
import com.delivery.api.domain.exception.EmailAlreadyRegistered;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.exception.PhoneNumberAlreadyRegistered;
import com.delivery.api.domain.repository.UserRepository;
import com.delivery.api.infra.persistence.jpa_entity.UserPersistence;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository<UserPersistence> userRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public UserService(
            @Qualifier("jpa") UserRepository<UserPersistence> userRepository,
            AuthenticationService authenticationService
    ){
            this.userRepository = userRepository;
            this.authenticationService = authenticationService;
    }

    public User findUser(Long userId){
        UserPersistence userPersistence = this.userRepository.findById(userId).orElseThrow(() -> new EntityNotFound("User not found"));
        return UserPersistence.convertUserPersistenceToUser(userPersistence);
    }

    public User findUserByEmail(String email){
        return this.userRepository.findByEmail(email).map(UserPersistence::convertUserPersistenceToUser).orElse(null);
    }

    public User findUserByCpf(String cpf){
        return this.userRepository.findByCpf(cpf).map(UserPersistence::convertUserPersistenceToUser).orElse(null);
    }

    public User findUserByPhoneNumber(String phoneNumber){
        return this.userRepository.findByPhoneNumber(phoneNumber).map(UserPersistence::convertUserPersistenceToUser).orElse(null);
    }

    private void validateUserUniqueness(Long userId, User user) {
        User existingUserByEmail = findUserByEmail(user.getEmail());
        if (existingUserByEmail != null && !existingUserByEmail.getId().equals(userId)) {
            throw new EmailAlreadyRegistered("E-mail already registered");
        }

        User existingUserByCpf = findUserByCpf(user.getCpf());
        if (existingUserByCpf != null && !existingUserByCpf.getId().equals(userId)) {
            throw new CpfAlreadyRegistered("Cpf already registered");
        }

        User existingUserByPhoneNumber = findUserByPhoneNumber(user.getPhoneNumber());
        if (existingUserByPhoneNumber != null && !existingUserByPhoneNumber.getId().equals(userId)) {
            throw new PhoneNumberAlreadyRegistered("Phone number already registered");
        }
    }


    @Transactional
    public User createUser(User user){
        this.validateUserUniqueness(null, user);

        String hashPassword = this.authenticationService.hashPassword(user.getPassword());
        user.setPassword(hashPassword);

        UserPersistence userPersistence = UserPersistence.convertUserToUserPersistence(user);
        userPersistence = this.userRepository.save(userPersistence);
        return UserPersistence.convertUserPersistenceToUser(userPersistence);
    }

    @Transactional
    public void updateUserPassword(Long userId, String currentPassword, String newPassword){
        User user = this.findUser(userId);
        boolean verifyCurrentPassword = this.authenticationService.checkPassword(currentPassword, user.getPassword());
        if(verifyCurrentPassword){
            throw new IllegalArgumentException("Current password is incorrect");
        }
        String hashPassword = this.authenticationService.hashPassword(newPassword);
        user.setPassword(hashPassword);
        UserPersistence userPersistence = UserPersistence.convertUserToUserPersistence(user);
        this.userRepository.save(userPersistence);
    }

    @Transactional
    public User updateUser(Long userId, User user){
        User userInDatabase = this.findUser(userId);
        user.setId(userId);

        this.validateUserUniqueness(userId, user);
        userInDatabase.setName(user.getName());
        userInDatabase.setEmail(user.getEmail());
        userInDatabase.setPhoneNumber(user.getPhoneNumber());

        UserPersistence userPersistence = UserPersistence.convertUserToUserPersistence(userInDatabase);
        this.userRepository.save(userPersistence);
        return UserPersistence.convertUserPersistenceToUser(userPersistence);
    }



}
