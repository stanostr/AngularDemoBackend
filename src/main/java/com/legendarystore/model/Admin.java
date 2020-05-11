package com.legendarystore.model;

import javax.persistence.Entity;

import com.legendarystore.security.SecurityConstants;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Admin extends User {
	private static final long serialVersionUID = 4819015115826404703L;

	@Builder
	public Admin(Long id, String username, String password,
			String firstName, String lastName, String email) {
		super(SecurityConstants.ADMIN_ROLE, id, username, password, firstName, lastName, email);
	}
	
}
