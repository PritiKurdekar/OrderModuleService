package com.app.order.controllers;

import java.util.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.order.dto.CreateOrderRequest;
import com.app.order.dto.OrderDetails;
import com.app.order.entities.Order;
import com.app.order.service.IOrderService;
import com.app.order.util.OrderUtil;

import antlr.collections.List;
import io.swagger.annotations.Api;

@Api("orders")
@Validated
@RequestMapping("/orders")
@RestController
public class OrderRestController {

	@Autowired
	private OrderUtil orderUtil;

	@Autowired
	private IOrderService service;

	@Autowired
	private RestTemplate restTemplate;

//	@GetMapping
//    public List<OrderDetails> allOrders() {
//        List<Order> list = service.findAll();
//        List<OrderDetails> response = orderUtil.toOrderDetailsList(list);
//        return response;
//    }

	@GetMapping("/byid/{id}")
	public OrderDetails getOrder(@PathVariable("id") long oid) {
		Order order = service.findOrderByOrderId(oid);
		OrderDetails response = orderUtil.toOrderDetails(order);
		return response;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public OrderDetails addOrder(@RequestBody CreateOrderRequest requestData) {
//		System.out.println("inside addOrder() \n CustomerID :" + requestData.getCustomerId()
//				+ "\nFurnitures Purchased : " + requestData.getFurnituresPurchased() + "\n Total amount : "
//				+ requestData.getTotalAmount() + "\nDate : " + requestData.getCreatedDate() + "\nFurniture Type : "
//				+ requestData.getFurnitureType());
//		Order created = service.add(requestData.getCustomerId(), requestData.getFurnituresPurchased(),
//				requestData.getTotalAmount(), requestData.getCreatedDate(), requestData.getFurnitureType());

		System.out.println("inside addOrder() \n CustomerID :" + requestData.getCustomerId() + "\n Total amount : "
				+ requestData.getTotalAmount() + "\nDate : " + requestData.getCreatedDate());
		Order created = service.add(requestData.getCustomerId(), requestData.getTotalAmount(),
				requestData.getCreatedDate());

		OrderDetails response = orderUtil.toOrderDetails(created);
		return response;
	}
}
