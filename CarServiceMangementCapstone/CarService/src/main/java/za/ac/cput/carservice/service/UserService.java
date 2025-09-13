package za.ac.cput.carservice.service;
import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.User;
import za.ac.cput.carservice.factory.UserFactory;
import za.ac.cput.carservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(
            String username,
            String password,
            String email,
            String phone,
            String role) {
        User user = UserFactory.createUser(username, password, email, phone, role);
        return repository.save(user);
    }


    public User save(User user) {
        return repository.save(user);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
