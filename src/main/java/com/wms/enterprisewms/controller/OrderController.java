package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.dto.CreateOrderRequest;
import com.wms.enterprisewms.entity.Order;
import com.wms.enterprisewms.entity.OrderStatus;
import com.wms.enterprisewms.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/status")
    public List<Order> getOrdersByStatus(
            @RequestParam OrderStatus status) {

        return orderService.getOrdersByStatus(status);
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status) {

        return orderService.updateOrderStatus(id, status);
    }
}