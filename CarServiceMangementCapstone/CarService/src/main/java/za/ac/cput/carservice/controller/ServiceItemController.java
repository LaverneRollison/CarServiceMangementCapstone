package za.ac.cput.carservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.carservice.domain.ServiceItem;
import za.ac.cput.carservice.service.ServiceItemService;

@RestController
@RequestMapping("api/serviceItem")
public class ServiceItemController {

    private final ServiceItemService service;

    public ServiceItemController(ServiceItemService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceItem> createServiceItem(@RequestParam int serviceId,
                                                         @RequestParam int itemId,
                                                         @RequestParam int quantityUsed,
                                                         @RequestParam double unitPriceUsed) {
        ServiceItem createdItem = service.createServiceItem(serviceId, itemId, quantityUsed, unitPriceUsed);
        return ResponseEntity.ok(createdItem);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceItem> saveServiceItem(@RequestBody ServiceItem serviceItem) {
        ServiceItem savedItem = service.save(serviceItem);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceItem>> getAllServiceItems() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceItem> getServiceItemById(@PathVariable int id) {
        Optional<ServiceItem> item = service.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteServiceItem(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}