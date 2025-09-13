package za.ac.cput.carservice.service;

import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.Booking;
import za.ac.cput.carservice.repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking save(Booking booking) {
        return repository.save(booking);
    }

    public Optional<Booking> findById(Long id) {
        return repository.findById(id);
    }

    public List<Booking> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
