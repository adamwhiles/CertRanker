package com.certranker.CertRanker_Backend.services;

import com.certranker.CertRanker_Backend.entities.Cert;
import com.certranker.CertRanker_Backend.entities.LearningResource;
import com.certranker.CertRanker_Backend.entities.Vote;
import com.certranker.CertRanker_Backend.repositories.CertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertServiceImpl implements CertService {

    private final CertRepository certRepository;

    public CertServiceImpl(CertRepository certRepository) {
        this.certRepository = certRepository;
    }

    @Override
    public Iterable<Cert> findAll() {
        return certRepository.findAll();
    }

    @Override
    public Cert findOneById(String id) {
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

    @Override
    public Cert addVoteToResource(String certId, String resourceId, Vote vote) {
        Optional<Cert> certOptional = certRepository.findById(certId);
        if (certOptional.isPresent()) {
            Cert cert = certOptional.get();
            List<LearningResource> resources = cert.getLearningResourceList();
            if (resources != null) {
                for(LearningResource resource : resources) {
                    if (resource.getId() != null) {
                        if (resource.getId().equals(resourceId)) {
                            resource.getVotes().add(vote);

                            return certRepository.save(cert);
                        }
                    }
                }
            }
            throw new RuntimeException("Resource with ID " + resourceId + " not found in Cert with ID " + certId);
        } else {
            throw new RuntimeException("Cert with ID " + certId + " not found");
        }
    }
}
