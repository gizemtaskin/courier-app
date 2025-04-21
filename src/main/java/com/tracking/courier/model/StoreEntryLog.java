package com.tracking.courier.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class StoreEntryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Courier courier;
    @ManyToOne
    private Store store;
    private LocalDateTime entryTime;

    public StoreEntryLog() {
    }

    public StoreEntryLog(Courier courier, Store store, LocalDateTime entryTime) {
        this.courier = courier;
        this.store = store;
        this.entryTime = entryTime;
    }

}
