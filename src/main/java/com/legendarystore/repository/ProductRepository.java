package com.legendarystore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legendarystore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByName(String name);
}
