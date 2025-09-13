package za.ac.cput.carservice.service;

import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.Mechanic;
import za.ac.cput.carservice.repository.MechanicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicService {
    private final MechanicRepository repository;

    public MechanicService(MechanicRepository repository) {
        this.repository = repository;
    }

    public Mechanic save(Mechanic mechanic) {
        return repository.save(mechanic);
    }

    public Optional<Mechanic> findById(Long id) {
        return repository.findById(id);
    }

    public List<Mechanic> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
