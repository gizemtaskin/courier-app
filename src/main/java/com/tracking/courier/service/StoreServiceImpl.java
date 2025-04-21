package com.tracking.courier.service;

import com.tracking.courier.model.Store;
import com.tracking.courier.repository.StoreRepository;
import com.tracking.courier.type.service.StoreService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository repo) {
        this.storeRepository = repo;
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStore(Store store) {
        storeRepository.save(store);
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}
