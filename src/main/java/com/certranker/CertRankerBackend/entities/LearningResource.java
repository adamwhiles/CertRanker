package com.certranker.CertRankerBackend.entities;

import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LearningResource {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String description;
    private String url;
    private Votes votes;

    public LearningResource() {
        this.id = UUID.randomUUID().toString();
    }

    public LearningResource(String name, String description, String url, Votes votes) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.url = url;
        this.votes = votes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Votes getVotes() {
        return votes;
    }

    public void setVotes(Votes votes) {
        this.votes = votes;
    }
}
