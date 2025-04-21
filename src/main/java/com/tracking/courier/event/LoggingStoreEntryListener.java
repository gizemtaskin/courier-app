package com.tracking.courier.event;

import com.tracking.courier.event.type.StoreEntryListener;
import com.tracking.courier.model.StoreEntryLog;
import com.tracking.courier.repository.StoreEntryLogRepository;
import org.springframework.stereotype.Component;

@Component
public class LoggingStoreEntryListener implements StoreEntryListener {

    private final StoreEntryLogRepository repository;

    public LoggingStoreEntryListener(StoreEntryLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onStoreEntry(StoreEntryLog log) {
        repository.save(log);
    }
}