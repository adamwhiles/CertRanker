package com.certranker.CertRankerBackend.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.certranker.CertRankerBackend.entities.User;

import java.util.Optional;

public interface UserRepository extends CosmosRepository<User, String> {
    Optional<User> findByEmail(String email);
}
