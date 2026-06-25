package com.wms.enterprisewms.service;

import com.wms.enterprisewms.entity.StorageBin;
import com.wms.enterprisewms.repository.StorageBinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageBinService {

    private final StorageBinRepository storageBinRepository;

    public StorageBinService(StorageBinRepository storageBinRepository) {
        this.storageBinRepository = storageBinRepository;
    }

    public StorageBin addStorageBin(StorageBin storageBin) {
        return storageBinRepository.save(storageBin);
    }

    public List<StorageBin> getAllStorageBins() {
        return storageBinRepository.findAll();
    }
}