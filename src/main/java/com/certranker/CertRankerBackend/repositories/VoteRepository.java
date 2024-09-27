package com.certranker.CertRankerBackend.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.certranker.CertRankerBackend.entities.Vote;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends CosmosRepository<Vote, String> {
    // Find votes by user ID
    List<Vote> findByUserId(@Param("userId") String userId);

    // Find votes by resource ID
    List<Vote> findByResourceId(@Param("resourceId") String resourceId);

    // Find a specific vote by user ID and resource ID
    Vote findByUserIdAndResourceId(@Param("userId") String userId, @Param("resourceId") String resourceId);
}
