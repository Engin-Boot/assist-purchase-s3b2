package com.example.purchase.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductAlreadyExistsException extends Exception {

	public ProductAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
