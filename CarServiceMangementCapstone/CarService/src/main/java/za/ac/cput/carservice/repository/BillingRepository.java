package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.carservice.domain.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
}
