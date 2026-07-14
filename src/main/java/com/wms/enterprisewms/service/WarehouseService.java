package com.wms.enterprisewms.service;

import com.wms.enterprisewms.dto.WarehouseCapacityResponse;
import com.wms.enterprisewms.entity.Warehouse;
import com.wms.enterprisewms.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public Warehouse addWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public List<WarehouseCapacityResponse> getWarehouseCapacity() {

        List<WarehouseCapacityResponse> response = new ArrayList<>();

        for (Warehouse warehouse : warehouseRepository.findAll()) {

            int occupiedBins = warehouse.getStorageBins().size();

            response.add(new WarehouseCapacityResponse(
                    warehouse.getWarehouseId(),
                    warehouse.getWarehouseName(),
                    warehouse.getCapacity(),
                    occupiedBins));
        }

        return response;
    }
}