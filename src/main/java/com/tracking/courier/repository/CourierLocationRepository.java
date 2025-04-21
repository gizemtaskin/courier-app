package com.tracking.courier.repository;

import com.tracking.courier.model.CourierLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierLocationRepository extends JpaRepository<CourierLocation, Long> {
    List<CourierLocation> findAllByCourierIdOrderByTimestamp(String courierId);
}