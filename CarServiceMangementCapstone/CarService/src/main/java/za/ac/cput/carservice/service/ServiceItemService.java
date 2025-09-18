package za.ac.cput.carservice.service;

import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.ServiceItem;
import za.ac.cput.carservice.factory.ServiceItemFactory;
import za.ac.cput.carservice.repository.ServiceItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceItemService {

    private final ServiceItemRepository repository;

    public ServiceItemService(ServiceItemRepository repository) {
        this.repository = repository;
    }

    public ServiceItem createServiceItem(int serviceId, int itemId, int quantityUsed, double unitPriceUsed) {
        ServiceItem serviceItem = ServiceItemFactory.createServiceItem(serviceId, itemId, quantityUsed, unitPriceUsed);
        return repository.save(serviceItem);
    }

    public ServiceItem save(ServiceItem serviceItem) { return repository.save(serviceItem);}

    public List<ServiceItem> findAll() { return repository.findAll();}

    public Optional<ServiceItem> findById(int id) { return repository.findById(id);}

    public void deleteById(int id) { repository.deleteById(id);}
}
