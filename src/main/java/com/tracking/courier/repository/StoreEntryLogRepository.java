package com.tracking.courier.repository;

import com.tracking.courier.model.StoreEntryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreEntryLogRepository extends JpaRepository<StoreEntryLog, Long> {
    Optional<StoreEntryLog> findTopByCourierIdAndStoreNameOrderByEntryTimeDesc(
            String courierId, String storeName);
}
