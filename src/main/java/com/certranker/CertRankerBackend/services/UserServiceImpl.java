package com.certranker.CertRankerBackend.services;

import com.certranker.CertRankerBackend.entities.User;
import com.certranker.CertRankerBackend.repositories.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;


    @Override
    public boolean userExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public void registerNewUser(User newUser) throws MessagingException {
        User user = new User(newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()), newUser.getEmail(), newUser.getProvider());
        userRepository.save(user);
        String verificationLink = "https://certranker.com/verify?token=" + user.getVerificationToken();
        String content = "<html>"
                + "<body>"
                + "<h1>Welcome to Certranker!</h1>"
                + "<p>Thank you for registering with Certranker. Please complete your registration by clicking the link below:</p>"
                + "<a href='" + verificationLink + "' style='color:#1a0dab; text-decoration:none; font-size:18px;'>Verify Your Account</a>"
                + "<p>If you did not request this registration, please ignore this email or inform us.</p>"
                + "<p>Best regards,<br>Certranker Team</p>"
                + "</body>"
                + "</html>";
        emailService.sendVerificationEmail(user.getEmail(), "Certranker - Verify your account", content);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return Optional.ofNullable(user.orElse(null));
    }

    @Override
    public Optional<User> verifyUser(String token) {
        Optional<User> user = userRepository.findByVerificationToken(token);
        if (user != null) {
            user.orElse(null).setVerified(true);
            userRepository.save(user.orElse(null));
            return user;
        }
        return null;
    }


}
