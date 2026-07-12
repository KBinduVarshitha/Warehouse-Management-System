package com.wms.enterprisewms.dto;

public class TransferRequest {

    private Long productId;
    private Long sourceBinId;
    private Long destinationBinId;
    private Integer quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSourceBinId() {
        return sourceBinId;
    }

    public void setSourceBinId(Long sourceBinId) {
        this.sourceBinId = sourceBinId;
    }

    public Long getDestinationBinId() {
        return destinationBinId;
    }

    public void setDestinationBinId(Long destinationBinId) {
        this.destinationBinId = destinationBinId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}