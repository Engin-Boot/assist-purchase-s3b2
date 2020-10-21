package com.example.purchase.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductDoesNotExistException extends Exception {

	public ProductDoesNotExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDoesNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
