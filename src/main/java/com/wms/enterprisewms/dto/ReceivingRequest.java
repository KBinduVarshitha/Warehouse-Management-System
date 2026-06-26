package com.wms.enterprisewms.dto;

public class ReceivingRequest {

    private Long productId;
    private Long storageBinId;
    private Integer quantity;

    public ReceivingRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStorageBinId() {
        return storageBinId;
    }

    public void setStorageBinId(Long storageBinId) {
        this.storageBinId = storageBinId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}