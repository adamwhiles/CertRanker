package com.certranker.CertRankerBackend.services;

import com.certranker.CertRankerBackend.entities.Cert;
import com.certranker.CertRankerBackend.entities.LearningResource;
import com.certranker.CertRankerBackend.entities.Vote;
import com.certranker.CertRankerBackend.repositories.CertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertServiceImpl implements CertService {

    private final CertRepository certRepository;

    @Autowired
    public CertServiceImpl(CertRepository certRepository) {
        this.certRepository = certRepository;
    }

    @Override
    public Iterable<Cert> findAll() {
        return certRepository.findAll();
    }

    @Override
    public Cert findById(String id) {
        return certRepository.findById(id).orElse(null);
    }

    @Override
    public Cert addResourceToCert(String id, LearningResource learningResource) {
        Optional<Cert> certOptional = certRepository.findById(id);

        if (certOptional.isPresent()) {
            Cert cert = certOptional.get();
            List<LearningResource> resources = cert.getLearningResourceList();
            resources.add(learningResource);
            cert.setLearningResourceList(resources);

            return certRepository.save(cert);
        } else {
            throw new RuntimeException("Cert with ID " + id + " not found");
        }
    }

}
