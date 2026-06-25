package com.wms.enterprisewms.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @Column(nullable = false)
    private String warehouseName;

    @Column(nullable = false)
    private String location;

    private Integer capacity;

    @OneToMany(mappedBy = "warehouse")
    private List<StorageBin> storageBins;

    public Warehouse() {
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<StorageBin> getStorageBins() {
        return storageBins;
    }

    public void setStorageBins(List<StorageBin> storageBins) {
        this.storageBins = storageBins;
    }
}