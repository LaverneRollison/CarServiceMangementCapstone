package za.ac.cput.carservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.carservice.domain.Billing;
import za.ac.cput.carservice.factory.BillingFactory;
import za.ac.cput.carservice.service.BillingService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3001/")
@RestController
@RequestMapping("/api/billings")
public class BillingController {

    private final BillingService service;

    public BillingController(BillingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Billing> create(@RequestBody Billing billingRequest) {
        Billing billing = BillingFactory.createBilling(
                billingRequest.getServiceOrder(),
                billingRequest.getAmount(),
                billingRequest.getPaymentStatus(),
                billingRequest.getPaymentDate()
        );
        return ResponseEntity.ok(service.save(billing));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Billing> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
