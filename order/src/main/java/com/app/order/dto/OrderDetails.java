package com.app.order.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.app.order.entities.FurnitureType;

public class OrderDetails {
	private Long orderId;
	private Long customerId;
	//Map<Long, Integer> furnituresPurchased = new HashMap<Long, Integer>();
	private double totalAmount;
	private LocalDate createdDate;
	//private FurnitureType furnitureType;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

//	public Map<Long, Integer> getFurnituresPurchased() {
//		return furnituresPurchased;
//	}
//
//	public void setFurnituresPurchased(Map<Long, Integer> furnituresPurchased) {
//		this.furnituresPurchased = furnituresPurchased;
//	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

//	public FurnitureType getFurnitureType() {
//		return furnitureType;
//	}
//
//	public void setFurnitureType(FurnitureType furnitureType) {
//		this.furnitureType = furnitureType;
//	}

}
