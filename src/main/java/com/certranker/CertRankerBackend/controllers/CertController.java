package com.certranker.CertRankerBackend.controllers;

import com.certranker.CertRankerBackend.entities.Cert;
import com.certranker.CertRankerBackend.entities.LearningResource;
import com.certranker.CertRankerBackend.entities.Vote;
import com.certranker.CertRankerBackend.repositories.CertRepository;
import com.certranker.CertRankerBackend.services.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CertController {

    @Autowired
    private final CertService certService;

    public CertController(CertService certService) {
        this.certService = certService;
    }


    // Get all cert
    @GetMapping("/certs")
    List<Cert> getCerts() {
        return (List<Cert>) certService.findAll();
    }

    // Get cer by id
    @GetMapping("/certs/{certId}")
    Optional<Cert> getCert(@PathVariable String certId) {
        return Optional.ofNullable(certService.findById(certId));
    }

    // Add learning resource to cert
    @PostMapping("/certs/{certId}/resources")
    public ResponseEntity<Cert> addResource(@PathVariable String certId, @RequestBody LearningResource learningResource) {
        Cert updatedCert = certService.addResourceToCert(certId, learningResource);
        return ResponseEntity.ok(updatedCert);
    }

}
