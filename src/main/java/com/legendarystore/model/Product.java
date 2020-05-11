package com.legendarystore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "prod_id")
	private Long id;

	@Column(name = "prod_name")
	private String name;
	
	@Column(name = "prod_desc")
	private String description;

	@Column(name = "prod_price")
	//@Pattern(regexp = "^[0-9]*\\.[0-9][0-9]$")
	private double price;

	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
}
