package com.tracking.courier.util;

import com.tracking.courier.util.type.DistanceCalculator;
import org.springframework.stereotype.Component;

@Component
public class HaversineDistanceCalculator implements DistanceCalculator {
    private static final double R = 6_371_000; // metre

    @Override
    public double calculate(double startLatitude, double startLongitude, double endLatitude, double endLongitude) {
        double startLatRad = Math.toRadians(startLatitude);
        double endLatRad = Math.toRadians(endLatitude);
        double deltaLatRad = Math.toRadians(endLatitude - startLatitude);
        double deltaLonRad = Math.toRadians(endLongitude - startLongitude);

        double haversineA = Math.sin(deltaLatRad / 2) * Math.sin(deltaLatRad / 2)
                + Math.cos(startLatRad) * Math.cos(endLatRad)
                * Math.sin(deltaLonRad / 2) * Math.sin(deltaLonRad / 2);

        double haversineC = 2 * Math.atan2(Math.sqrt(haversineA), Math.sqrt(1 - haversineA));

        return R * haversineC; // R: Dünya'nın yarıçapı (genelde 6371 km olarak tanımlanır)
    }
}
