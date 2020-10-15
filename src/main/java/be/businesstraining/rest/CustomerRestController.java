package be.businesstraining.rest;

import be.businesstraining.domain.Customer;
import be.businesstraining.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerRestController {

    private CustomerRepository repository;

    @Autowired
    public CustomerRestController(CustomerRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public Iterable<Customer> allTheCustomers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")  // Chemin effectif /customers/2
    public ResponseEntity<Customer> findById(@PathVariable(name = "id") Long id) {
          Optional<Customer> result = repository.findById(id);
          return  (result.isPresent())?
                      new ResponseEntity<>(result.get(), HttpStatus.OK):
                      new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping (params = "namePart")
                                    // Chemin effectif /customers?namePart=chris
    public List<Customer> findByNameContaining(
                        @PathParam(value = "namePart") String namePart) {
        return     repository.findAllByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCase(namePart, namePart);
    }


}
