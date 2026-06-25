package com.wms.enterprisewms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "storage_bins")
public class StorageBin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long binId;

    @Column(nullable = false)
    private String binCode;

    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    public StorageBin() {
    }

    public Long getBinId() {
        return binId;
    }

    public void setBinId(Long binId) {
        this.binId = binId;
    }

    public String getBinCode() {
        return binCode;
    }

    public void setBinCode(String binCode) {
        this.binCode = binCode;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}