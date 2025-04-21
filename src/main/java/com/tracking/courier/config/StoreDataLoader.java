package com.tracking.courier.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracking.courier.model.Courier;
import com.tracking.courier.model.Store;
import com.tracking.courier.repository.CourierRepository;
import com.tracking.courier.repository.StoreRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.util.List;

@Component
public class StoreDataLoader implements ApplicationRunner {

    private final StoreRepository storeRepository;
    private final CourierRepository courierRepository;
    private final ObjectMapper objectMapper;


    public StoreDataLoader(StoreRepository storeRepository, CourierRepository courierRepository, ObjectMapper objectMapper) {
        this.storeRepository = storeRepository;
        this.courierRepository = courierRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Store örnek veriler
        InputStream is = new ClassPathResource("stores.json").getInputStream();
        List<Store> stores = objectMapper.readValue(is, new TypeReference<>() {});
        storeRepository.saveAll(stores);

        // Courier örnek veriler
        Courier courier1 = new Courier("C001", "Gizem Taşkın");
        Courier courier2 = new Courier("C002", "Ahmet Taşkın");
        Courier courier3 = new Courier("C003", "Mehmet Taşkın");
        Courier courier4 = new Courier("C004", "Ayşe Taşkın");

        courierRepository.saveAll(List.of(courier1, courier2, courier3, courier4));

        System.out.println("Store ve Courier verileri başarıyla yüklendi!");
    }
}
