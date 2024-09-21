package com.certranker.CertRanker_Backend.controllers;

import com.certranker.CertRanker_Backend.services.CertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final CertService certService;

    public IndexController(CertService certService) {
        this.certService = certService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("certs",certService.findAll());
        return "index";
    }
}
