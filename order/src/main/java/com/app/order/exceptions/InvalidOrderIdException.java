package com.app.order.exceptions;

public class InvalidOrderIdException extends RuntimeException {
	public InvalidOrderIdException(String msg) {
		super(msg);
	}
}
