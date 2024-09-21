package com.certranker.CertRanker_Backend.services;

import com.certranker.CertRanker_Backend.entities.Cert;
import com.certranker.CertRanker_Backend.entities.LearningResource;
import com.certranker.CertRanker_Backend.entities.Vote;
import com.certranker.CertRanker_Backend.repositories.CertRepository;

public interface CertService {


    Iterable<Cert> findAll();
    Cert findOneById(String id);
    Cert addResourceToCert(String id, LearningResource learningResource);
    Cert addVoteToResource(String certId, String resourceId, Vote vote);
}
