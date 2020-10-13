package be.businesstraining.rest;

import be.businesstraining.domain.Customer;
import be.businesstraining.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerRestController {

    private CustomerRepository repository;

    @Autowired
    public CustomerRestController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    public Iterable<Customer> allTheCustomers() {
        return repository.findAll();
    }
}
