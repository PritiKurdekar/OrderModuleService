package com.app.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.order.entities.Order;

public interface IOrderRepository extends JpaRepository<Order,Long> {
	//Order findByOrderId(Long orderId);
	List<Order>findByCustomerId(Long customerId);
}
