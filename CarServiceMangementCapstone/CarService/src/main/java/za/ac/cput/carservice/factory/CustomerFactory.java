package za.ac.cput.carservice.factory;

import za.ac.cput.carservice.domain.Customer;

public class CustomerFactory {

    private CustomerFactory() {

    }

    public static Customer createCustomer(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or blank");
        }
        return new Customer.Builder()
                .address(address.trim())
                .build();
    }
}
