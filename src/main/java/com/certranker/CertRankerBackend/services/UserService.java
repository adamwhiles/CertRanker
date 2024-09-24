package com.certranker.CertRankerBackend.services;

import com.certranker.CertRankerBackend.entities.User;

import java.util.Optional;

public interface UserService {
    boolean userExists(String email);
    void registerNewUser(User newUser);
    Optional<User> getUserByEmail(String email);
}
