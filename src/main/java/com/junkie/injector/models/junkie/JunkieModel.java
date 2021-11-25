package com.junkie.injector.models.junkie;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("junkie")
public class JunkieModel {

    @Id
    private Long id;
    private String name;
    private Instant timeStamp;
    public JunkieModel(){}
    public JunkieModel(String name) {
        this.name = name;
        this.timeStamp = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
}
