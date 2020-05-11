package com.legendarystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legendarystore.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByUsername(String username);
}
