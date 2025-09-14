package za.ac.cput.carservice.service;
import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.ServiceOrder;
import za.ac.cput.carservice.repository.ServiceOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderService {
    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderService(ServiceOrderRepository serviceOrderRepository) {
        this.serviceOrderRepository = serviceOrderRepository;
    }

    public ServiceOrder save(ServiceOrder serviceOrder) {
        return serviceOrderRepository.save(serviceOrder);
    }

    public Optional<ServiceOrder> findById(Long id) {
        return serviceOrderRepository.findById(id);
    }

    public List<ServiceOrder> findAll() {
        return serviceOrderRepository.findAll();
    }

    public void deleteById(Long id) {
        serviceOrderRepository.deleteById(id);
    }

    public ServiceOrder update(ServiceOrder serviceOrder) {
        if (serviceOrder.getServiceOrderId() == null || !serviceOrderRepository.existsById(serviceOrder.getServiceOrderId())) {
            throw new IllegalArgumentException("ServiceOrder does not exist");
        }
        return serviceOrderRepository.save(serviceOrder);
    }

    public void delete(Long id) {
    }
}
