package com.certranker.CertRankerBackend.services;

import com.certranker.CertRankerBackend.entities.Cert;
import com.certranker.CertRankerBackend.entities.LearningResource;
import com.certranker.CertRankerBackend.entities.Vote;

public interface CertService {


    Iterable<Cert> findAll();
    Cert findById(String id);
    Cert addResourceToCert(String id, LearningResource learningResource);
}
