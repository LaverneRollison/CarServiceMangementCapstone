package za.ac.cput.carservice.factory;

import za.ac.cput.carservice.domain.Customer;

public class CustomerFactory {

    private CustomerFactory() {

    }

    public static Customer createCustomer(Long customerId,String address, String Username, String Password, String Email, String Phone, String Role) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or blank");
        }
        return new Customer.Builder()
                .setAddress(address)
                .setUsername(Username)
                .setPassword(Password)
                .setEmail(Email)
                .setPhone(Phone)
                .setRole(Role)
                .build();

    }
}
