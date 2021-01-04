package com.netset.exception;

public class ProductException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductException(String e) {
		super(e);
	}

	public ProductException(String message, Throwable ex) {
		super(message, ex);
	}

}
