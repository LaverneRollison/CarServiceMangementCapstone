package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.carservice.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
