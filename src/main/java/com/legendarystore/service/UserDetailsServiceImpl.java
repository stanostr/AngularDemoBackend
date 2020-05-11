package com.legendarystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.legendarystore.model.Admin;
import com.legendarystore.model.Customer;
import com.legendarystore.repository.AdminRepository;
import com.legendarystore.repository.CustomerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByUsername(username);
		if (customer != null)
			return customer;
		Admin admin = adminRepository.findByUsername(username);
		if (admin != null)
			return admin;
		throw new UsernameNotFoundException("User not found");
	}

}
