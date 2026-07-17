package com.wms.enterprisewms.repository;

import com.wms.enterprisewms.entity.Order;
import com.wms.enterprisewms.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);

}