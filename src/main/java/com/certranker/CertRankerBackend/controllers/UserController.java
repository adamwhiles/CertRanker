package com.certranker.CertRankerBackend.controllers;

import com.certranker.CertRankerBackend.entities.User;
import com.certranker.CertRankerBackend.services.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.regex.Pattern;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public ResponseEntity<Optional<User>> getUser(@RequestParam String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(u -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping("/registernewuser")
    public ModelAndView registerUser(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("confirm-password") String confirmPassword, @RequestParam("username") String username, RedirectAttributes redirectAttributes) throws MessagingException {

        final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");


        ModelAndView modelAndView = new ModelAndView();
        if (userService.userExists(email)) {
            redirectAttributes.addFlashAttribute("error", "User with this email already exists");
            modelAndView.setViewName("redirect:/register");
            return modelAndView;
        }
        if (!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "Passwords do not match");
            modelAndView.setViewName("redirect:/register");
            return modelAndView;
        }
        if (password.length() < 8) {
            redirectAttributes.addFlashAttribute("error", "Password must be at least 8 characters long.");
            modelAndView.setViewName("redirect:/register");
            return modelAndView;
        }
        if (!SPECIAL_CHAR_PATTERN.matcher(password).find()) {
            redirectAttributes.addFlashAttribute("error", "Password must contain at least one special character.");
            modelAndView.setViewName("redirect:/register");
            return modelAndView;
        }


        User newUser = new User(username, password, email, "EMAIL");

        userService.registerNewUser(newUser);
        modelAndView.setViewName("index.html");
        return modelAndView;
    }


}
