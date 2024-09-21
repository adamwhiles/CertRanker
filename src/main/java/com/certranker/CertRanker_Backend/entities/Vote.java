package com.certranker.CertRanker_Backend.entities;

import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;
import java.util.UUID;

public class Vote {

    @Id
    @GeneratedValue
    private String id;
    private String userId;
    private int vote;

    public Vote(String userId, int vote) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.vote = vote;
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

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

}
