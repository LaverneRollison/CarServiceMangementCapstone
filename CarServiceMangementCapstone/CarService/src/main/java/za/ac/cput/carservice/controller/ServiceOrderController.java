package za.ac.cput.carservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.carservice.domain.ServiceOrder;
import za.ac.cput.carservice.factory.ServiceOrderFactory;
import za.ac.cput.carservice.service.ServiceOrderService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3001/")
@RestController
@RequestMapping("/api/service-orders")
public class ServiceOrderController {

    private final ServiceOrderService service;

    public ServiceOrderController(ServiceOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServiceOrder> create(@RequestBody ServiceOrder serviceOrderRequest) {
        ServiceOrder serviceOrder = ServiceOrderFactory.createServiceOrder(
                serviceOrderRequest.getBookingId(),
                serviceOrderRequest.getMechanicId(),
                serviceOrderRequest.getServiceDate(),
                serviceOrderRequest.getDescription(),
                serviceOrderRequest.getStatus()
        );
        return ResponseEntity.ok(service.save(serviceOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrder> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ServiceOrder> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
