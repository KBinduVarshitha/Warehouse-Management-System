package com.wms.enterprisewms.service;

import com.wms.enterprisewms.dto.DashboardResponse;
import com.wms.enterprisewms.repository.InventoryItemRepository;
import com.wms.enterprisewms.repository.InventoryTransactionRepository;
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
    private final InventoryTransactionRepository transactionRepository;

    public DashboardService(
            ProductRepository productRepository,
            WarehouseRepository warehouseRepository,
            StorageBinRepository storageBinRepository,
            InventoryItemRepository inventoryItemRepository,
            InventoryTransactionRepository transactionRepository) {

        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.storageBinRepository = storageBinRepository;
        this.inventoryItemRepository = inventoryItemRepository;
        this.transactionRepository = transactionRepository;
    }

    public DashboardResponse getDashboardData() {

        return new DashboardResponse(
                productRepository.count(),
                warehouseRepository.count(),
                storageBinRepository.count(),
                inventoryItemRepository.count(),
                transactionRepository.count()
        );
    }
}