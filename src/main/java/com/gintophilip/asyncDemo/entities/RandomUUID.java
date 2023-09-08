package com.gintophilip.asyncDemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RandomUUID {
    @Id
    private Long id;
    private String UUID;

    public RandomUUID() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
