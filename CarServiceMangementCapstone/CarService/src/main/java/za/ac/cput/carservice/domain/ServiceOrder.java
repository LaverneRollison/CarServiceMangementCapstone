package za.ac.cput.carservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceOrderId;

    private Long bookingId;
    private Long mechanicId;
    private LocalDate serviceDate;
    private String description;
    private String status;

    public ServiceOrder() {}

    private ServiceOrder(Builder builder) {
        this.serviceOrderId = builder.serviceOrderId;
        this.bookingId = builder.bookingId;
        this.mechanicId = builder.mechanicId;
        this.serviceDate = builder.serviceDate;
        this.description = builder.description;
        this.status = builder.status;
    }
    public Long getServiceOrderId() { return serviceOrderId; }
    public Long getBookingId() { return bookingId; }
    public Long getMechanicId() { return mechanicId; }
    public LocalDate getServiceDate() { return serviceDate; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

    public static class Builder {
        private Long serviceOrderId;
        private Long bookingId;
        private Long mechanicId;
        private LocalDate serviceDate;
        private String description;
        private String status;

        public Builder setServiceOrderId(Long serviceOrderId) {
            this.serviceOrderId = serviceOrderId;
            return this;
        }
        public Builder setBookingId(Long bookingId) {

            this.bookingId = bookingId;
            return this;
        }

        public Builder setMechanicId(Long mechanicId) {

            this.mechanicId = mechanicId;
            return this;
        }
        public Builder setServiceDate(LocalDate serviceDate) {
            this.serviceDate = serviceDate;
            return this;
        }
        public Builder setDescription(String description) {

            this.description = description;
            return this;
        }
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        public ServiceOrder build() {
            return new ServiceOrder(this);
        }
    }
}
