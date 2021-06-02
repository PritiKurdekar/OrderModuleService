package com.app.order.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.app.order.dto.CreateOrderRequest;
import com.app.order.dto.OrderDetails;
import com.app.order.entities.FurnitureType;
import com.app.order.entities.Order;

public interface IOrderService {
	OrderDetails add(CreateOrderRequest request);

	Order findOrderByOrderId(Long oid);

	List<Order> findOrderByCustomerId(Long cid);

	//Order add(Long customerId, Map<Long, Integer> furnituresPurchased, double totalAmount, LocalDate createdDate,
			//FurnitureType furnitureType);
	Order add(Long customerId, double totalAmount, LocalDate createdDate);

	List<Order> findAll();

	

	// void deleteById(int id);

}
