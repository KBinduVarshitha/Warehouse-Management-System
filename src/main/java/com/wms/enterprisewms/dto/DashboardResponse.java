package com.wms.enterprisewms.dto;

public class DashboardResponse {

    private long totalProducts;
    private long totalWarehouses;
    private long totalStorageBins;
    private long totalInventoryItems;
    private long totalTransactions;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalProducts,
                             long totalWarehouses,
                             long totalStorageBins,
                             long totalInventoryItems,
                             long totalTransactions) {

        this.totalProducts = totalProducts;
        this.totalWarehouses = totalWarehouses;
        this.totalStorageBins = totalStorageBins;
        this.totalInventoryItems = totalInventoryItems;
        this.totalTransactions = totalTransactions;
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

    public long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }
}