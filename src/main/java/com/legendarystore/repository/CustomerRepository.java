package com.legendarystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legendarystore.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByUsername(String username);
}
