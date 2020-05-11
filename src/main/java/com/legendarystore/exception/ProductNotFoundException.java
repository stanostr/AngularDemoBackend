package com.legendarystore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2497604422123618787L;
	
	public ProductNotFoundException(String message)
	{
		super(message);
	}
}
