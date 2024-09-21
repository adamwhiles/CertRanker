package com.certranker.CertRanker_Backend.entities;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Container(containerName = "learningresources")
public class Cert {

    @Id
    @PartitionKey
    private String id;
    private String name;
    private String description;
    private String url;

    private List<LearningResource> learningResourceList;

    public Cert(String id, String name, String description, String url, List<LearningResource> learningResourceList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.learningResourceList = (learningResourceList == null) ? new ArrayList<>() : learningResourceList;
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

    public List<LearningResource> getLearningResourceList() {
        return learningResourceList;
    }

    public void setLearningResourceList(List<LearningResource> learningResourceList) {
        this.learningResourceList = learningResourceList;
    }

    @Override
    public String toString() {
        return "Cert{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
