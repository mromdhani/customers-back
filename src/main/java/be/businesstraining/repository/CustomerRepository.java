package be.businesstraining.repository;

import java.util.List;

import be.businesstraining.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository
        extends CrudRepository<Customer, Long> {


}