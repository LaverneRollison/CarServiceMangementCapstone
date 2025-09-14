package za.ac.cput.carservice.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingId;
    @OneToOne
    @JoinColumn(name = "service_order_id", nullable = false)
    private ServiceOrder serviceOrder;

    private Double amount;
    private String paymentStatus;
    private LocalDate paymentDate;

    public Billing() {

    }

    private Billing(Builder builder) {
        this.billingId = builder.billingId;
        this.serviceOrder = builder.serviceOrder;
        this.amount = builder.amount;
        this.paymentStatus = builder.paymentStatus;
        this.paymentDate = builder.paymentDate;
    }
    public Long getBillingId() { return billingId; }
    public ServiceOrder getServiceOrder() { return serviceOrder; }
    public Double getAmount() { return amount; }
    public String getPaymentStatus() { return paymentStatus; }
    public LocalDate getPaymentDate() { return paymentDate; }


    public static class Builder {
        private Long billingId;
        private ServiceOrder serviceOrder;
        private Double amount;
        private String paymentStatus;
        private LocalDate paymentDate;


        public Builder setBillingId(Long billingId) {
            this.billingId = billingId;
            return this;
        }
        public Builder setServiceOrder(ServiceOrder serviceOrder) {
            this.serviceOrder = serviceOrder;
            return this;
        }
        public Builder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }
        public Builder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }
        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder copy(Billing billing) {
            this.billingId = billing.getBillingId();
            this.serviceOrder = billing.getServiceOrder();
            this.amount = billing.getAmount();
            this.paymentStatus = billing.getPaymentStatus();
            this.paymentDate = billing.getPaymentDate();
            return this;
        }

        public Billing build() {
            return new Billing(this);
        }
    }
}
