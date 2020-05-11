package com.legendarystore.service;

import java.util.List;

import com.legendarystore.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	Product getProductById(Long id);

	List<Product> getAllProducts();

	Product deleteProduct(Long id);

	List<Product> findProductsByName(String name);

}