package za.ac.cput.carservice.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.carservice.domain.InventoryItem;
import za.ac.cput.carservice.service.InventoryItemService;


@RestController
@RequestMapping("/inventoryItem")
public class InventoryItemController {

    private final InventoryItemService service;

    public InventoryItemController(InventoryItemService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public ResponseEntity<InventoryItem> createItem(@RequestParam String itemName,
                                                    @RequestParam int quantity,
                                                    @RequestParam double price,
                                                    @RequestParam int lowStock) {
        InventoryItem createdItem = service.createInventoryItem(itemName, quantity, price, lowStock);
        return ResponseEntity.ok(createdItem);
    }


    @PostMapping("/save")
    public ResponseEntity<InventoryItem> saveItem(@RequestBody InventoryItem inventoryItem) {
        InventoryItem savedItem = service.save(inventoryItem);
        return ResponseEntity.ok(savedItem);
    }


    @GetMapping("/all")
    public ResponseEntity<List<InventoryItem>> getAllItems() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> getItemById(@PathVariable Long id) {
        Optional<InventoryItem> item = service.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/low-stock/{id}")
    public ResponseEntity<Boolean> checkLowStock(@PathVariable Long id) {
        boolean lowStock = service.isLowStock(id);
        return ResponseEntity.ok(lowStock);
    }
}
