package com.junkie.injector.models.operations;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("junkieInjection")
public class JunkieInjectionModel {
    @Id
    private Long id;
    private Long injectorID;
    private Long injectedID;
    private Long medsID;
    private Instant timeStamp;
    public JunkieInjectionModel(Long injectorID, Long injectedID, Long medsID) {
        this.injectorID = injectorID;
        this.injectedID = injectedID;
        this.medsID = medsID;
    }

    public Long getId() {
        return id;
    }

    public Long getInjectorID() {
        return injectorID;
    }

    public Long getInjectedID() {
        return injectedID;
    }

    public Long getMedsID() {
        return medsID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInjectorID(Long injectorID) {
        this.injectorID = injectorID;
    }

    public void setInjectedID(Long injectedID) {
        this.injectedID = injectedID;
    }

    public void setMedsID(Long medsID) {
        this.medsID = medsID;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
}
