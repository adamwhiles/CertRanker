package com.certranker.CertRanker_Backend.entities;

import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;

public class Vote {

    @Id
    @GeneratedValue
    private String id;
    private String userId;

    public Vote(String id, String userId) {
        this.id = id;
        this.userId = userId;
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
}
