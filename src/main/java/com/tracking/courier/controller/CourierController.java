package com.tracking.courier.controller;

import com.tracking.courier.dto.LocationRequest;
import com.tracking.courier.model.Courier;
import com.tracking.courier.repository.CourierRepository;
import com.tracking.courier.type.service.CourierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courier")
public class CourierController {
    private final CourierRepository courierRepository;
    private final CourierService courierService;

    public CourierController(CourierRepository courierRepository, CourierService courierService) {
        this.courierRepository = courierRepository;
        this.courierService = courierService;
    }

    @PostMapping("/locations")
    public ResponseEntity<Void> addLocation(@RequestBody LocationRequest req) {
        Courier c = courierRepository.findById(req.getCourierId())
                .orElseGet(() -> courierRepository.save(
                        new Courier(req.getCourierId(), req.getCourierName())));
        courierService.logCourierLocation(c, req.getLatitude(), req.getLongitude());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/distance")
    public ResponseEntity<Double> getTotalDistance(@PathVariable String id) {
        if (!courierRepository.existsById(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(courierService.getTotalTravelDistance(id));
    }
}
