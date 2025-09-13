package za.ac.cput.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.carservice.domain.InventoryItem;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
}
