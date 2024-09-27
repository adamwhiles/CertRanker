package com.certranker.CertRankerBackend.entities;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Container(containerName = "votes")
public class Vote {

    @Id
    @GeneratedValue
    private String id;
    private String userId;
    private String resourceId;
    private String voteType;

    public Vote(String userId, String resourceId, String voteType, String vote) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.resourceId = resourceId;
        this.voteType = voteType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }
}
