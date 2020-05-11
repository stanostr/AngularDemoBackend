package com.legendarystore.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.legendarystore.model.Admin;
import com.legendarystore.model.Customer;
import com.legendarystore.repository.AdminRepository;
import com.legendarystore.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {

	@Mock
	AdminRepository adminRepository;

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	public UserDetailsServiceImpl userDetailsServiceImpl;

	@Test
	public void testFindCustomer() {
		Customer expectedCustomer = Customer.builder().username("Sven").password("abc123").email("sven@abc.com")
				.build();
		when(customerRepository.findByUsername(anyString())).thenReturn(expectedCustomer);
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername("Sven");
		assertEquals("Sven", userDetails.getUsername());
		assertEquals("abc123", userDetails.getPassword());
	}

	@Test
	public void testFindAdmin() {
		Admin expectedAdmin = Admin.builder().username("Sven").password("abc123").email("sven@abc.com").build();
		when(adminRepository.findByUsername(anyString())).thenReturn(expectedAdmin);
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername("Sven");
		assertEquals("Sven", userDetails.getUsername());
		assertEquals("abc123", userDetails.getPassword());
	}

	@Test
	public void throwNoUserFound() {
		assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername("Sven"));
	}
}