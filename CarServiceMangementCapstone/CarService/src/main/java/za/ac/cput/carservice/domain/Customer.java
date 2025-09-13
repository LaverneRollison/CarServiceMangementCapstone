package za.ac.cput.carservice.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String address;

    protected Customer() {
        // Required by JPA
    }

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.address = builder.address;
    }

    public Long getCustomerId() { return customerId; }
    public String getAddress() { return address; }

    public void updateAddress(String newAddress) {
        if (newAddress == null || newAddress.isBlank()) {
            throw new IllegalArgumentException("Address cannot be blank");
        }
        this.address = newAddress.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    public static class Builder {
        private Long customerId;
        private String address;

        public Builder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Customer build() {
            if (address == null || address.isBlank()) {
                throw new IllegalStateException("Address is required");
            }
            return new Customer(this);
        }
    }
}
