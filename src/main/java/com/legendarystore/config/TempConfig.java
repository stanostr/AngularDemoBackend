package com.legendarystore.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.legendarystore.model.Admin;
import com.legendarystore.model.Customer;
import com.legendarystore.model.Product;
import com.legendarystore.repository.AdminRepository;
import com.legendarystore.repository.CustomerRepository;
import com.legendarystore.repository.OrderRepository;
import com.legendarystore.repository.ProductRepository;

@Configuration
public class TempConfig {

	@Bean
	public CommandLineRunner dataLoader(AdminRepository adminRepository, CustomerRepository custRepo, OrderRepository orderRepo, ProductRepository prodRepo, PasswordEncoder passwordEncoder)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				prodRepo.save(new Product("Bottle", "Cheap plastic water bottle", 1.00));
				custRepo.save(Customer.builder().username("sven").password(passwordEncoder.encode("abc123")).email("sven@aol.com").build());
				custRepo.save(Customer.builder().username("olaf").password(passwordEncoder.encode("abc321")).email("olaf@aol.com").build());
				adminRepository.save(Admin.builder().username("silky").password(passwordEncoder.encode("abc123")).email("silky@aol.com").build());
			}
		};
	}
}
