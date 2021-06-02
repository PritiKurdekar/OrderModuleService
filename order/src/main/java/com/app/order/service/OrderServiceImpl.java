package com.app.order.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.order.dao.IOrderRepository;
import com.app.order.dto.CreateOrderRequest;
import com.app.order.dto.FurnitureDetails;
import com.app.order.dto.OrderDetails;
import com.app.order.entities.FurnitureType;
import com.app.order.entities.Order;
import com.app.order.exceptions.InvalidCustomerIdException;
import com.app.order.exceptions.InvalidOrderIdException;
import com.app.order.exceptions.InvalidTotalAmountException;
import com.app.order.exceptions.OrderNotFoundException;
import com.app.order.util.OrderUtil;

@Transactional
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderRepository repository;

	@Autowired
	private OrderUtil orderUtil;

	@Override
	public OrderDetails add(CreateOrderRequest request) {
		validateCustomerId(request.getCustomerId());

		Order order = new Order();
		order.setCustomerId(request.getCustomerId());
		Map<Long, Integer> furnituresPurchased = request.getFurnituresPurchased();
		order.setFurnituresPurchased(furnituresPurchased);
		LocalDateTime now = LocalDateTime.now();
		order.setCreatedDate(now);
		Set<Long> furnitureIds = furnituresPurchased.keySet();
		Map<Long, Double> furnitures = fetchFurnitureDetails(furnitureIds);
		double orderAmount = 0;

		for (Long furnitureId : furnitureIds) {
			double furnitureCost = furnitures.get(furnitureId);
			int quantity = furnituresPurchased.get(furnitureId);
			double totalFurnitureCost = furnitureCost * quantity;
			orderAmount = orderAmount + totalFurnitureCost;
		}
		order.setTotalAmount(orderAmount);
		order = repository.save(order);
		OrderDetails details = orderUtil.toOrderDetails(order);
		return details;
	}

	Map<Long, Double> fetchFurnitureDetails(Collection<Long> furnitureIds) {
		Map<Long, Double> map = new HashMap<>();
		map.put(1L, 50D);
		map.put(2L, 10D);

		return map;
	}

	@Override
	public Order findOrderByOrderId(Long oid) {
		validateOrderId(oid);
		Optional<Order> optional = repository.findById(oid);
		if (!optional.isPresent()) {
			throw new OrderNotFoundException("Order not found for orderid=" + oid);
		}
		return optional.get();
	}

	@Override
	public List<Order> findOrderByCustomerId(Long cid) {
		validateCustomerId(cid);
		Optional<Order> optional = repository.findById(cid);
		if (!optional.isPresent()) {
			throw new OrderNotFoundException("Order not found for customerid=" + cid);
		}
		return (List<Order>) optional.get();
//		List<Order> list = repository.findByCustomerId(cid);		
//        return list;
	}

	void validateOrderId(long id) {
		if (id < 0) {
			throw new InvalidOrderIdException("orderid can't be negative");
		}
	}

	void validateCustomerId(long id) {
		if (id < 0) {
			throw new InvalidCustomerIdException("customerid can't be negative");
		}
	}

	void validateTotalAmount(double totalAmount) {
		if (totalAmount < 0) {
			throw new InvalidTotalAmountException("amount can't be negative");
		}

	}

//	@Override
//	public Order add(Long customerId, Map<Long, Integer> furnituresPurchased, double totalAmount, LocalDate createdDate,
//			FurnitureType furnitureType) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Order add(Long customerId, double totalAmount, LocalDate createdDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		List<Order> list = repository.findAll();
		return list;
	}

}
