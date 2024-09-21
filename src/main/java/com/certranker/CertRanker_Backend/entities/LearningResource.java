package com.certranker.CertRanker_Backend.entities;

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

    private List<Vote> votes;

    public LearningResource() {
        this.id = UUID.randomUUID().toString();
    }

    public LearningResource(String name, String description, String url, List<Vote> votes) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.url = url;
        this.votes = (votes == null) ? new ArrayList<>() : votes;
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

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
