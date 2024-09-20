package com.certranker.CertRanker_Backend.controllers;

import com.certranker.CertRanker_Backend.entities.Cert;
import com.certranker.CertRanker_Backend.repositories.CertRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CertController {
    private final CertRepository certRepository;

    public CertController(final CertRepository certRepository) {
        this.certRepository = certRepository;
    }

    @GetMapping("/certs")
    List<Cert> getCerts() {
        return (List<Cert>) certRepository.findAll();
    }
}
