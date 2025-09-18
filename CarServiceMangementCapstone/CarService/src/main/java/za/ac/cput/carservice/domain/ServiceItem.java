package za.ac.cput.carservice.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "serviceItem")
public class ServiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceItemId;
    private int serviceId;
    private int itemId;
    private int quantityUsed;
    private double unitPriceUsed;

    private ServiceItem(Builder builder) {
        this.serviceItemId = builder.serviceItemId;
        this.serviceId = builder.serviceId;
        this.itemId = builder.itemId;
        this.quantityUsed = builder.quantityUsed;
        this.unitPriceUsed = builder.unitPriceUsed;
    }

    public ServiceItem() {}

    public int getServiceItemId() { return serviceItemId;}

    public int getServiceId() { return serviceId;}

    public int getItemId() { return itemId;}

    public int getQuantityUsed() { return quantityUsed;}

    public double getUnitPriceUsed() { return unitPriceUsed;}

    public static class Builder {
        private int serviceItemId;
        private int serviceId;
        private int itemId;
        private int quantityUsed;
        private double unitPriceUsed;

        public Builder setServiceItemId(int serviceItemId) {
            this.serviceItemId = serviceItemId;
            return this;
        }

        public Builder setServiceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder setItemId(int itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder setQuantityUsed(int quantityUsed) {
            this.quantityUsed = quantityUsed;
            return this;
        }

        public Builder setUnitPriceUsed(double unitPriceUsed) {
            this.unitPriceUsed = unitPriceUsed;
            return this;
        }

        public Builder copy(ServiceItem serviceItem) {
            this.serviceItemId = serviceItem.serviceItemId;
            this.serviceId = serviceItem.serviceId;
            this.itemId = serviceItem.itemId;
            this.quantityUsed = serviceItem.quantityUsed;
            this.unitPriceUsed = serviceItem.unitPriceUsed;
            return this;
        }

        public ServiceItem build() {
            return new ServiceItem(this);
        }
    }

    @Override
    public String toString() {
        return "ServiceItem{" +
                "serviceItemId=" + serviceItemId +
                ", serviceId=" + serviceId +
                ", itemId=" + itemId +
                ", quantityUsed=" + quantityUsed +
                ", unitPriceUsed=" + unitPriceUsed +
                '}';
    }
}
