package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.carservice.domain.ServiceOrder;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
