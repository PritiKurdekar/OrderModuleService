package com.app.order.exceptions;

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException(String msg) {
		super(msg);
	}
}
