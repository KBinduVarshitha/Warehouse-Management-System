package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.dto.WarehouseCapacityResponse;
import com.wms.enterprisewms.entity.Warehouse;
import com.wms.enterprisewms.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.addWarehouse(warehouse);
    }

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/capacity")
    public List<WarehouseCapacityResponse> getWarehouseCapacity() {
        return warehouseService.getWarehouseCapacity();
    }
}