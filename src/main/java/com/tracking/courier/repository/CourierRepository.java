package com.tracking.courier.repository;

import com.tracking.courier.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, String> {
}
