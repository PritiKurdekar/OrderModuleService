package com.app.order.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.app.order.entities.FurnitureType;

public class CreateOrderRequest {
	private Long customerId;
	private Map<Long, Integer> furnituresPurchased;
	private String furnitureType;

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

	public String getFurnitureType() {
		return furnitureType;
	}

	public void setFurnitureType(String furnitureType) {
		this.furnitureType = furnitureType;
	}

}
