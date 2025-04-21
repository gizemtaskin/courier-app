package com.tracking.courier.service;

import com.tracking.courier.event.type.StoreEntryListener;
import com.tracking.courier.model.Courier;
import com.tracking.courier.model.CourierLocation;
import com.tracking.courier.model.Store;
import com.tracking.courier.model.StoreEntryLog;
import com.tracking.courier.repository.CourierLocationRepository;
import com.tracking.courier.repository.CourierRepository;
import com.tracking.courier.repository.StoreEntryLogRepository;
import com.tracking.courier.repository.StoreRepository;
import com.tracking.courier.type.service.CourierService;
import com.tracking.courier.util.type.DistanceCalculator;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;
    private final CourierLocationRepository courierLocationRepository;
    private final StoreRepository storeRepository;
    private final StoreEntryLogRepository storeEntryLogRepository;
    private final DistanceCalculator distanceCalculator;
    private final List<StoreEntryListener> storeEntryListeners;

    public CourierServiceImpl(CourierRepository courierRepository,
                              CourierLocationRepository courierLocationRepository,
                              StoreRepository storeRepository,
                              StoreEntryLogRepository storeEntryLogRepository,
                              DistanceCalculator distanceCalculator,
                              List<StoreEntryListener> storeEntryListeners) {
        this.courierRepository = courierRepository;
        this.courierLocationRepository = courierLocationRepository;
        this.storeRepository = storeRepository;
        this.storeEntryLogRepository = storeEntryLogRepository;
        this.distanceCalculator = distanceCalculator;
        this.storeEntryListeners = storeEntryListeners;
    }

    @Override
    public Courier getCourierById(String id) {
        return courierRepository.findById(id).orElse(null);
    }

    @Override
    public void logCourierLocation(Courier courier, double latitude, double longitude) {
        LocalDateTime now = LocalDateTime.now();
        courierLocationRepository.save(new CourierLocation(courier, latitude, longitude, now));
        // mağaza girişi kontrolü
        for (Store store : storeRepository.findAll()) {
            double d = distanceCalculator.calculate(latitude, longitude,
                    store.getLat(), store.getLng());
            if (d <= 100) {
                Optional<StoreEntryLog> last = storeEntryLogRepository
                        .findTopByCourierIdAndStoreNameOrderByEntryTimeDesc(
                                courier.getId(), store.getName());
                if (last.isEmpty() ||
                        last.get().getEntryTime().isBefore(now.minusMinutes(1))) {
                    StoreEntryLog log = new StoreEntryLog(courier, store, now);
                    storeEntryListeners.forEach(l -> l.onStoreEntry(log));
                }
            }
        }
    }

    @Override
    public double getTotalTravelDistance(String courierId) {
        List<CourierLocation> locations = courierLocationRepository.findAllByCourierIdOrderByTimestamp(courierId);

        if (locations.size() < 2) {
            return 0.0; // en az iki lokasyon olmalı
        }

        double totalDistance = 0.0;

        for (int i = 1; i < locations.size(); i++) {
            CourierLocation previous = locations.get(i - 1);
            CourierLocation current = locations.get(i);

            double distance = distanceCalculator.calculate(
                    previous.getLatitude(), previous.getLongitude(),
                    current.getLatitude(), current.getLongitude());

            totalDistance += distance;
        }

        return totalDistance;
    }
}
