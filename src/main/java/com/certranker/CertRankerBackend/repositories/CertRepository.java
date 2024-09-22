package com.certranker.CertRankerBackend.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.certranker.CertRankerBackend.entities.Cert;


public interface CertRepository extends CosmosRepository<Cert, String> {

}
