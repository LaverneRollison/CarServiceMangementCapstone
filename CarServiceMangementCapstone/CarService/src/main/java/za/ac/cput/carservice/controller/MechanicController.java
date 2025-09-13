package za.ac.cput.carservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.carservice.domain.Mechanic;
import za.ac.cput.carservice.service.MechanicService;

import java.util.List;

@RestController
@RequestMapping("/api/mechanics")
public class MechanicController {

    private final MechanicService service;

    public MechanicController(MechanicService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Mechanic> create(@RequestBody Mechanic mechanic) {
        return ResponseEntity.ok(service.save(mechanic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mechanic> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Mechanic> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
