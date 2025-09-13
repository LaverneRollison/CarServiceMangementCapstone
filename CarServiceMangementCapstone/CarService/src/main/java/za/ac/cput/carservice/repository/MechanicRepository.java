package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.carservice.domain.Mechanic;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
}
