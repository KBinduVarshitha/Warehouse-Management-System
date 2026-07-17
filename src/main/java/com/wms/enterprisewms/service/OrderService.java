package com.wms.enterprisewms.service;

import com.wms.enterprisewms.dto.CreateOrderRequest;
import com.wms.enterprisewms.entity.InventoryItem;
import com.wms.enterprisewms.entity.Order;
import com.wms.enterprisewms.entity.OrderStatus;
import com.wms.enterprisewms.entity.Product;
import com.wms.enterprisewms.exception.InsufficientStockException;
import com.wms.enterprisewms.repository.InventoryItemRepository;
import com.wms.enterprisewms.repository.OrderRepository;
import com.wms.enterprisewms.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final InventoryItemRepository inventoryItemRepository;

    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        InventoryItemRepository inventoryItemRepository) {

        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public Order createOrder(CreateOrderRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Order order = new Order();
        order.setProduct(product);
        order.setQuantity(request.getQuantity());
        order.setStatus(OrderStatus.PENDING);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order updateOrderStatus(Long orderId, OrderStatus status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        if (status == OrderStatus.PACKED) {

            InventoryItem inventory = inventoryItemRepository
                    .findByProductProductId(order.getProduct().getProductId())
                    .orElseThrow(() ->
                            new RuntimeException("Inventory not found"));

            if (inventory.getQuantity() < order.getQuantity()) {
                throw new InsufficientStockException("Insufficient stock available");
            }

            inventory.setQuantity(
                    inventory.getQuantity() - order.getQuantity());

            inventoryItemRepository.save(inventory);
        }

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }
}