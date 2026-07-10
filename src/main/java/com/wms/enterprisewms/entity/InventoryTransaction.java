package com.wms.enterprisewms.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_transactions")
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private InventoryItem inventoryItem;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Integer quantity;

    private LocalDateTime transactionTime;

    public InventoryTransaction() {
    }

    public InventoryTransaction(InventoryItem inventoryItem,
                                TransactionType transactionType,
                                Integer quantity,
                                LocalDateTime transactionTime) {
        this.inventoryItem = inventoryItem;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.transactionTime = transactionTime;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}