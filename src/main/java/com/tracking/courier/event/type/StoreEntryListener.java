package com.tracking.courier.event.type;

import com.tracking.courier.model.StoreEntryLog;

public interface StoreEntryListener {
    void onStoreEntry(StoreEntryLog log);
}