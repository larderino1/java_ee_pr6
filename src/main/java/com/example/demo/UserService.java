package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email){
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return entityManager.merge(user);
    }
}
