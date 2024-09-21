package com.certranker.CertRanker_Backend.controllers;

import com.certranker.CertRanker_Backend.entities.Cert;
import com.certranker.CertRanker_Backend.entities.LearningResource;
import com.certranker.CertRanker_Backend.entities.Vote;
import com.certranker.CertRanker_Backend.repositories.CertRepository;
import com.certranker.CertRanker_Backend.services.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CertController {

    @Autowired
    private CertService certService;

    private final CertRepository certRepository;

    public CertController(final CertRepository certRepository) {
        this.certRepository = certRepository;
    }

    // Get all cert
    @GetMapping("/certs")
    List<Cert> getCerts() {
        return (List<Cert>) certRepository.findAll();
    }

    // Get cer by id
    @GetMapping("/certs/{certId}")
    Optional<Cert> getCert(@PathVariable String certId) {
        return certRepository.findById(certId);
    }

    // Add learning resource to cert
    @PostMapping("/certs/{certId}/resources")
    public ResponseEntity<Cert> addResource(@PathVariable String certId, @RequestBody LearningResource learningResource) {
        Cert updatedCert = certService.addResourceToCert(certId, learningResource);
        return ResponseEntity.ok(updatedCert);
    }

    @PostMapping("/certs/{certId}/resources/{resourceId}/votes")
    public ResponseEntity<Cert> addVoteToResource(@PathVariable String certId, @PathVariable String resourceId, @RequestBody Vote vote) {
        Cert updatedCert = certService.addVoteToResource(certId, resourceId, vote);
        return ResponseEntity.ok(updatedCert);
    }

}
