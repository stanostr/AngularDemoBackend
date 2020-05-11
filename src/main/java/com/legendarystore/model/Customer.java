package com.legendarystore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.legendarystore.security.SecurityConstants;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends User {

	private static final long serialVersionUID = 8447807196776783982L;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> customerOrders;

	@Builder
	public Customer(Long id, String username, String password,
			String firstName, String lastName, String email, @Singular List<Order> customerOrders) {
		super(SecurityConstants.CUSTOMER_ROLE, id, username, password, firstName, lastName, email);
		this.customerOrders = customerOrders;
	}

	
}
