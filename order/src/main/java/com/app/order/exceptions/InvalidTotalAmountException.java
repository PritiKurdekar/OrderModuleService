package com.app.order.exceptions;

public class InvalidTotalAmountException extends RuntimeException {
	public InvalidTotalAmountException(String msg) {
		super(msg);
	}
}
