package com.gf.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "pomit", type = "issue", createIndex = false)
public class FQuestionElasticssearch {
    private Long id;
    private String title;
    private String catory;
    private String content;

    public FQuestionElasticssearch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCatory(String catory) {
        this.catory = catory;
    }

    public String getCatory() {
        return catory;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}