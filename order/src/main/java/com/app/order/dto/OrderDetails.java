package com.app.order.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.app.order.entities.FurnitureType;

public class OrderDetails {
	private Long orderId;
	private Long customerId;
	private Map<Long, Integer> furnituresPurchased;
	private double totalAmount;
	private LocalDateTime createdDate;
	private FurnitureType furnitureType;
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
	public Map<Long, Integer> getFurnituresPurchased() {
		return furnituresPurchased;
	}
	public void setFurnituresPurchased(Map<Long, Integer> furnituresPurchased) {
		this.furnituresPurchased = furnituresPurchased;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime localDateTime) {
		this.createdDate = localDateTime;
	}
	public FurnitureType getFurnitureType() {
		return furnitureType;
	}
	public void setFurnitureType(FurnitureType furnitureType2) {
		this.furnitureType = furnitureType2;
	}	
	
	
}
