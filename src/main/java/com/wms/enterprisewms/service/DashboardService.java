package com.wms.enterprisewms.service;

import com.wms.enterprisewms.entity.DashboardSummary;
import com.wms.enterprisewms.repository.InventoryItemRepository;
import com.wms.enterprisewms.repository.ProductRepository;
import com.wms.enterprisewms.repository.StorageBinRepository;
import com.wms.enterprisewms.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final StorageBinRepository storageBinRepository;
    private final InventoryItemRepository inventoryItemRepository;

    public DashboardService(ProductRepository productRepository,
                            WarehouseRepository warehouseRepository,
                            StorageBinRepository storageBinRepository,
                            InventoryItemRepository inventoryItemRepository) {

        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.storageBinRepository = storageBinRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public DashboardSummary getSummary() {

        return new DashboardSummary(
                productRepository.count(),
                warehouseRepository.count(),
                storageBinRepository.count(),
                inventoryItemRepository.count()
        );
    }
}