package za.ac.cput.carservice.service;

import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.Vehicle;
import za.ac.cput.carservice.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Optional<Vehicle> findById(Long id) {
        return repository.findById(id);
    }

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

