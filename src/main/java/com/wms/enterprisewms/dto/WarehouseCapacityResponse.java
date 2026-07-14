package com.wms.enterprisewms.dto;

public class WarehouseCapacityResponse {

    private Long warehouseId;
    private String warehouseName;
    private Integer capacity;
    private Integer occupiedBins;

    public WarehouseCapacityResponse() {
    }

    public WarehouseCapacityResponse(Long warehouseId,
                                     String warehouseName,
                                     Integer capacity,
                                     Integer occupiedBins) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.capacity = capacity;
        this.occupiedBins = occupiedBins;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getOccupiedBins() {
        return occupiedBins;
    }

    public void setOccupiedBins(Integer occupiedBins) {
        this.occupiedBins = occupiedBins;
    }
}