package be.businesstraining.repository;

import java.util.List;

import be.businesstraining.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository
        extends CrudRepository<Customer, Long> {

   public  List<Customer>
        findAllByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCase(String s1, String s2);
}