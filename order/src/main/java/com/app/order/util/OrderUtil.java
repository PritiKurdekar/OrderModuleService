package com.app.order.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.order.dto.OrderDetails;
import com.app.order.entities.Order;

@Component
public class OrderUtil {
	public OrderDetails toOrderDetails(Order order) {
		OrderDetails details = new OrderDetails();
		details.setOrderId(order.getOrderId());
		details.setCustomerId(order.getCustomerId());
		// details.setFurnituresPurchased(order.getFurnituresPurchased());
		details.setTotalAmount(order.getTotalAmount());
		details.setCreatedDate(order.getCreatedDate());
		// details.setFurnitureType(order.getFurnitureType());

		return details;
	}

	public List<OrderDetails> toOrderDetailsList(Collection<Order> orders) {

		List<OrderDetails> desired = new ArrayList<>();
		for (Order o : orders) {
			OrderDetails details = toOrderDetails(o);
			desired.add(details);
		}
		return desired;
	}
}