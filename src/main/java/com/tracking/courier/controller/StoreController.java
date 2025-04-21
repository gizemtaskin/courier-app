package com.tracking.courier.controller;

import com.tracking.courier.model.Store;
import com.tracking.courier.type.service.StoreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> list() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public Store get(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @PostMapping
    public void create(@RequestBody Store store) {
        storeService.saveStore(store);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        storeService.deleteStore(id);
    }
}
