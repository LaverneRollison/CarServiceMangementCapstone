package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.carservice.domain.Billing;


public interface BillingRepository extends JpaRepository<Billing, Long> {
}
