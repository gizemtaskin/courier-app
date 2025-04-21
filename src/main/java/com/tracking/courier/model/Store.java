package com.tracking.courier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double lat;
    private double lng;

    public Store() {
    }

    public Store(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

}
