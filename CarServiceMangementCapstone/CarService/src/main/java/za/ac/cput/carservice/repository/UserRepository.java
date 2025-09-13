package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.carservice.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
