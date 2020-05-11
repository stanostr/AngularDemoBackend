package com.legendarystore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legendarystore.exception.ProductNotFoundException;
import com.legendarystore.model.Product;
import com.legendarystore.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
	}
	
	@Override
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	@Override
	public Product deleteProduct(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
		productRepository.deleteById(id);
		return product;
	}
	
	@Override
	public List<Product> findProductsByName(String name)
	{
		return productRepository.findByName(name);
	}

}
