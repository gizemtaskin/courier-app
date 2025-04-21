package com.tracking.courier.type.service;

import com.tracking.courier.model.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAllStores();

    Store getStoreById(Long id);

    void saveStore(Store store);

    void deleteStore(Long id);
}
