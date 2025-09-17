package za.ac.cput.carservice.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String address;

    public Customer() {super();}

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.address = builder.address;
        this.Username = builder.Username;
        this.Password = builder.Password;
        this.Email = builder.Email;
        this.Phone = builder.Phone;
        this.Role = builder.Role;
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
public String toString() {return "Customer{"+super.toString()+"CustomerId"+customerId+"Address"+address+"}";}

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
        private String Username;
        private String Password;
        private String Email;
        private String Phone;
        private String Role;

        public Builder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Customer.Builder setAddress(String Address) {
            this.address = Address;
            return this;
        }
        public Customer.Builder setUsername(String Username) {
            this.Username= Username;
            return this;
}
public Customer.Builder setPassword(String password) {
            this.Password = password;
            return this;
}
public Customer.Builder setEmail(String email) {
            this.Email = email;
            return this;
}
public Customer.Builder setPhone(String phone) {
            this.Phone = phone;
            return this;
}
public Customer.Builder setRole(String role) {
            this.Role = role;
            return this;
}

public User copy(Customer customer) {
            this.customerId = customer.customerId;
            this.address = customer.address;
            this.Username = customer.getUsername();
            this.Password = customer.getPassword();
            this.Email = customer.getEmail();
            this.Phone = customer.getPhone();
            this.Role = customer.getRole();
            return this.build();
}
        public Customer build() {
            return new Customer(this);
        }
    }
}
