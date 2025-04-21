package com.tracking.courier.type.service;

import com.tracking.courier.model.Courier;

public interface CourierService {
    Courier getCourierById(String id);

    double getTotalTravelDistance(String courierId);

    void logCourierLocation(Courier courier, double latitude, double longitude);
}