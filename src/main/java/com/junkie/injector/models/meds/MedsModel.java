package com.junkie.injector.models.meds;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("meds")
public class MedsModel {
    @Id
    private Long id;
    private String name;
    public MedsModel(){
        this.id = null;
        this.name = null;
    }
    public MedsModel( String name) {
        this.id = null;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
