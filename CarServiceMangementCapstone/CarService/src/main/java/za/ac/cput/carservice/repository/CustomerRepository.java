package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.carservice.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
