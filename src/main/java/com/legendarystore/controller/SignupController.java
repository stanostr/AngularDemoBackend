package com.legendarystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.legendarystore.model.Customer;
import com.legendarystore.repository.CustomerRepository;
import com.legendarystore.security.SecurityConstants;

@RestController
@RequestMapping("/signup")
public class SignupController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void signup(@RequestBody Customer newCustomer)
	{
		newCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
		newCustomer.setRole(SecurityConstants.CUSTOMER_ROLE);
		customerRepository.save(newCustomer);
	}
}
