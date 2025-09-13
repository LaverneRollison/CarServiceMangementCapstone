package za.ac.cput.carservice.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.carservice.domain.User;
import za.ac.cput.carservice.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestParam String username,
                                           @RequestParam String password,
                                           @RequestParam String email,
                                           @RequestParam(required = false) String phone,
                                           @RequestParam String role) {
        User createdUser = service.createUser(username, password, email, phone, role);
        return ResponseEntity.ok(createdUser);
    }


    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = service.save(user);
        return ResponseEntity.ok(savedUser);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = service.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
