package com.certranker.CertRankerBackend.services;

import com.certranker.CertRankerBackend.entities.User;
import jakarta.mail.MessagingException;

import java.util.Optional;

public interface UserService {
    boolean userExists(String email);
    void registerNewUser(User newUser) throws MessagingException;
    Optional<User> getUserByEmail(String email);
    Optional<User> verifyUser(String token);
}
