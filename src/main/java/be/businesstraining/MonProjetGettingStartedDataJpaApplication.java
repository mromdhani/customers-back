package be.businesstraining;

import be.businesstraining.domain.Customer;
import be.businesstraining.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @Configuration + @ComponentScan + @EnableAutoConfiguration
public class MonProjetGettingStartedDataJpaApplication {
	private static final Logger log =
			LoggerFactory.getLogger(MonProjetGettingStartedDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MonProjetGettingStartedDataJpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(Customer.builder()
										.firstName("Jack")
										.lastName("Bauer")
										.build());
			repository.save(Customer.builder()
										.firstName("Chloe")
										.lastName("O'Brian")
										.build());

			repository.save(Customer.builder()
										.firstName("Kim")
										.lastName("Bauer")
										.build());

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}

		};
	}


}
