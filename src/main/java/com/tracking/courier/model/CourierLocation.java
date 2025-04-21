package com.tracking.courier.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CourierLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;

    @ManyToOne
    private Courier courier;

    public CourierLocation() {
    }

    public CourierLocation(Courier courier, double latitude, double longitude, LocalDateTime timestamp) {
        this.courier = courier;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }
}
