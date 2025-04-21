package com.tracking.courier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Courier {
    @Id
    private String id;
    private String name;

    public Courier() {
    }

    public Courier(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
