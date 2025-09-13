package za.ac.cput.carservice.service;

import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.Customer;
import za.ac.cput.carservice.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
