package za.ac.cput.carservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.carservice.domain.Booking;
import za.ac.cput.carservice.factory.BookingFactory;
import za.ac.cput.carservice.service.BookingService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3001/")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking bookingRequest) {
        Booking booking = BookingFactory.createBooking(
                bookingRequest.getCustomerId(),
                bookingRequest.getVehicleId(),
                bookingRequest.getScheduledDate(),
                bookingRequest.getStatus()
        );
        return ResponseEntity.ok(service.save(booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
