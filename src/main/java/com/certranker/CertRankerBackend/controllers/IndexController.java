package com.certranker.CertRankerBackend.controllers;

import com.certranker.CertRankerBackend.services.CertService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final CertService certService;

    public IndexController(CertService certService) {
        this.certService = certService;
    }



    @RequestMapping("/")
    public String index(Authentication authentication, Model model) {
        if (authentication != null) {
            System.out.println("User: " + authentication.getName());  // Will print the username or email of the logged-in user
        } else {
            System.out.println("User is not authenticated");
        }
        model.addAttribute("certs",certService.findAll());
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/certs/{certId}")
    public String showCert(@PathVariable String certId, Model model) {
        model.addAttribute("cert", certService.findById(certId));
        return "cert";
    }

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @GetMapping("/login")
    public String loginUser() {
        return "login";
    }
}
