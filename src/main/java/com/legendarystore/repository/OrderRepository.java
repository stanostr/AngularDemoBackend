package com.legendarystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legendarystore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
