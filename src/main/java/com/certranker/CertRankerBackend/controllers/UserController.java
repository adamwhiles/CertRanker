package com.certranker.CertRankerBackend.controllers;

import com.certranker.CertRankerBackend.entities.User;
import com.certranker.CertRankerBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
    public ModelAndView registerUser(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("username") String username, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();
        if (userService.userExists(email)) {
            redirectAttributes.addFlashAttribute("error", "User with this email already exists");
            modelAndView.setViewName("redirect:/register");

            return modelAndView;
        }

        User newUser = new User(username, password, email, "EMAIL");

        userService.registerNewUser(newUser);
        modelAndView.setViewName("index.html");
        return modelAndView;
    }


}
