package za.ac.cput.carservice.service;


import org.springframework.stereotype.Service;
import za.ac.cput.carservice.domain.Billing;
import za.ac.cput.carservice.repository.BillingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService  {
    private final BillingRepository billingRepository;

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Billing save(Billing billing) {
        return billingRepository.save(billing);
    }

    public Optional<Billing> findById(Long id) {
        return billingRepository.findById(id);
    }

    public List<Billing> findAll() {
        return billingRepository.findAll();
    }

    public void deleteById(Long id) {
        billingRepository.deleteById(id);
    }

    public Billing update(Billing billing) {
        if (billing.getBillingId() == null || !billingRepository.existsById(billing.getBillingId())) {
            throw new IllegalArgumentException("Billing record does not exist");
        }
        return billingRepository.save(billing);
    }

    public void delete(Long id) {
    }
}
