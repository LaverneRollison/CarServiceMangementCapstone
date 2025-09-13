package za.ac.cput.carservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.carservice.domain.Vehicle;
import za.ac.cput.carservice.factory.VehicleFactory;
import za.ac.cput.carservice.service.VehicleService;

import java.util.List;
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {this.service = service;}

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicleRequest) {
        Vehicle vehicle = VehicleFactory.createVehicle(
                vehicleRequest.getMake(),
                vehicleRequest.getModel(),
                vehicleRequest.getYear(),
                vehicleRequest.getLicensePlate()
        );
        return ResponseEntity.ok(service.save(vehicle));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return service.findAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


