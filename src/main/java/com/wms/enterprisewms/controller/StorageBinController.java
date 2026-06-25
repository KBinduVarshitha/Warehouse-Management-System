package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.entity.StorageBin;
import com.wms.enterprisewms.service.StorageBinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage-bins")
public class StorageBinController {

    private final StorageBinService storageBinService;

    public StorageBinController(StorageBinService storageBinService) {
        this.storageBinService = storageBinService;
    }

    @PostMapping
    public StorageBin addStorageBin(@RequestBody StorageBin storageBin) {
        return storageBinService.addStorageBin(storageBin);
    }

    @GetMapping
    public List<StorageBin> getAllStorageBins() {
        return storageBinService.getAllStorageBins();
    }
}