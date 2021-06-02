package com.app.order.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
	@GeneratedValue
	@Id
	private Long orderId;
	private Long customerId;
	// Map<Long, Integer> furnituresPurchased = new HashMap<Long, Integer>();
	private double totalAmount;
	private LocalDate createdDate;
	// private FurnitureType furnitureType;

//	public Order(Long customerId, Map<Long, Integer> furnituresPurchased, double totalAmount, LocalDate createdDate,
//			FurnitureType furnitureType) {
//
//		this.customerId = customerId;
//		this.furnituresPurchased = furnituresPurchased;
//		this.totalAmount = totalAmount;
//		this.createdDate = createdDate;
//		this.furnitureType = furnitureType;
//	}
	public Order(Long customerId, double totalAmount, LocalDate createdDate) {

		this.customerId = customerId;

		this.totalAmount = totalAmount;
		this.createdDate = createdDate;

	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Order order = (Order) o;
		return Objects.equals(orderId, order.orderId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

}
