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
										.firstName("Christian")
										.lastName("MAMAY")
										.build());
			repository.save(Customer.builder()
										.firstName("Jonathan")
										.lastName("ORDONEZ")
										.build());

			repository.save(Customer.builder()
										.firstName("Yorick")
										.lastName("WEENEN")
										.build());
			repository.save(Customer.builder()
					.firstName("Abderzak")
					.lastName("OULAD CHAIB")
					.build());

			repository.save(Customer.builder()
					.firstName("Noureddine")
					.lastName("RACHDI")
					.build());

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAllByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCase("z", "z")) {
				log.info(customer.toString());
			}

		};
	}


}
