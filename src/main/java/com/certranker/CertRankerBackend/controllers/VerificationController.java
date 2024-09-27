package com.certranker.CertRankerBackend.controllers;

import com.certranker.CertRankerBackend.entities.User;
import com.certranker.CertRankerBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class VerificationController {

    @Autowired
    private UserService userService;

    @GetMapping("/verify")
    public ModelAndView verifyUser(@RequestParam("token") String token) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> user = userService.verifyUser(token);
        if (user.isPresent() && user.get().isVerified()) {
            modelAndView.setViewName("redirect:/login?verified=true");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/login?error=verification");
        return modelAndView;
    }

}
