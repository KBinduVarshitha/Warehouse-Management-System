package com.wms.enterprisewms.entity;

public class DashboardSummary {

    private long totalProducts;
    private long totalWarehouses;
    private long totalStorageBins;
    private long totalInventoryItems;

    public DashboardSummary() {
    }

    public DashboardSummary(long totalProducts,
                            long totalWarehouses,
                            long totalStorageBins,
                            long totalInventoryItems) {

        this.totalProducts = totalProducts;
        this.totalWarehouses = totalWarehouses;
        this.totalStorageBins = totalStorageBins;
        this.totalInventoryItems = totalInventoryItems;
    }

    public long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public long getTotalWarehouses() {
        return totalWarehouses;
    }

    public void setTotalWarehouses(long totalWarehouses) {
        this.totalWarehouses = totalWarehouses;
    }

    public long getTotalStorageBins() {
        return totalStorageBins;
    }

    public void setTotalStorageBins(long totalStorageBins) {
        this.totalStorageBins = totalStorageBins;
    }

    public long getTotalInventoryItems() {
        return totalInventoryItems;
    }

    public void setTotalInventoryItems(long totalInventoryItems) {
        this.totalInventoryItems = totalInventoryItems;
    }
}