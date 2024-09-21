package com.certranker.CertRanker_Backend.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.certranker.CertRanker_Backend.entities.Cert;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CertRepository extends CrudRepository<Cert, String> {

}
