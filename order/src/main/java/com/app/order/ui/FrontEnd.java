package com.app.order.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.order.dto.CreateOrderRequest;
import com.app.order.dto.OrderDetails;
import com.app.order.exceptions.InvalidCustomerIdException;
import com.app.order.exceptions.InvalidOrderIdException;
import com.app.order.exceptions.InvalidTotalAmountException;
import com.app.order.service.IOrderService;

@Component
public class FrontEnd {
	@Autowired
	private IOrderService service;

	public void start() {
		try {
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			System.out.println();
			System.out.println("Place an Order");
			System.out.println("-------------------------------------");
			System.out.println("CustomerId : ");
			Long cid = sc.nextLong();

			Map<Long, Integer> map = new HashMap<>();
			map.put(1L, 10);

			System.out.println("Furniture type:");
			String type = sc.nextLine();
			CreateOrderRequest request = new CreateOrderRequest(cid, map, type);
			OrderDetails orderDetails = service.add(request);
			

		} catch (InvalidCustomerIdException e) {
			System.out.println(e.getMessage());
		} catch (InvalidOrderIdException e) {
			System.out.println(e.getMessage());
		} catch (InvalidTotalAmountException e) {
			System.out.println(e.getMessage());
		}
	}

	void display(OrderDetails details) {
		System.out.println(details.getOrderId() + "\n" + details.getCustomerId() + "\n"
				+ details.getFurnituresPurchased() + "\n" + details.getTotalAmount() + "\n" + details.getCreatedDate()
				+ "\n" + details.getFurnitureType());
	}

	void displayOrderDetails(Collection<OrderDetails> alldetails) {
		for (OrderDetails order : alldetails) {
			display(order);
		}
	}
}
