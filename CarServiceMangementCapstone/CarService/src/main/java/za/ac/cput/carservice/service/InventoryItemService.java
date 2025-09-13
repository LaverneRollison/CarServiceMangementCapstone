package za.ac.cput.carservice.service;
import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.InventoryItem;
import za.ac.cput.carservice.factory.InventoryItemFactory;
import za.ac.cput.carservice.repository.InventoryItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemService {

    private final InventoryItemRepository repository;

    public InventoryItemService(InventoryItemRepository repository) {
        this.repository = repository;
    }


    public InventoryItem createInventoryItem(String itemName, int quantity, double price, int lowStock) {
        InventoryItem inventoryItem = InventoryItemFactory.createInventoryItem(itemName, quantity, price, lowStock);
        return repository.save(inventoryItem);
    }


    public InventoryItem save(InventoryItem inventoryItem) {
        return repository.save(inventoryItem);
    }


    public Optional<InventoryItem> findById(Long id) {
        return repository.findById(id);
    }


    public List<InventoryItem> findAll() {
        return repository.findAll();
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    public boolean isLowStock(Long id) {
        Optional<InventoryItem> itemOpt = repository.findById(id);
        if (itemOpt.isPresent()) {
            InventoryItem item = itemOpt.get();
            return item.getQuantity() <= item.getLowStock();
        }
        return false;
    }
}