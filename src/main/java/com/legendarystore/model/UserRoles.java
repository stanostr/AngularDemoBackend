package com.legendarystore.model;

public enum UserRoles {
	ADMIN_ROLE("ROLE_ADMIN"), CUSTOMER_ROLE("ROLE_CUSTOMER");

	private String role;
	
	UserRoles(String role) {
		this.role = role;
	}
	
    @Override
    public String toString() {
        return role;
    }
}
