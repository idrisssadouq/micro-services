package com.sid.customerservice;

import com.sid.customerservice.entities.Customer;
import com.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null,"idriss","idriss@live.fr"));
			customerRepository.save(new Customer(null,"mohamed","mohamed@live.fr"));
			customerRepository.save(new Customer(null,"siham","siham@live.fr"));
			customerRepository.save(new Customer(null,"fatiha","fatiah@live.fr"));
			customerRepository.findAll().forEach( c -> {
				System.out.println(c.toString());
			});
		};
	}

}
