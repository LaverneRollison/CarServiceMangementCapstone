package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.carservice.domain.ServiceItem;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Integer> {
}
