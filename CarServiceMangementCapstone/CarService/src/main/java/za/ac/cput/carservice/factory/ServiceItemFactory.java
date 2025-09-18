package za.ac.cput.carservice.factory;

import za.ac.cput.carservice.domain.ServiceItem;

public class ServiceItemFactory {

    public static ServiceItem createServiceItem(int serviceId, int itemId, int quantityUsed, double unitPriceUsed) {
        if (serviceId <= 0 || itemId <= 0) {
            throw new IllegalArgumentException("ServiceId and ItemId must be positive integers.");
        }
        if (quantityUsed <= 0) {
            throw new IllegalArgumentException("QuantityUsed must be greater than zero.");
        }
        if (unitPriceUsed < 0) {
            throw new IllegalArgumentException("UnitPriceUsed cannot be negative.");
        }

        return new ServiceItem.Builder()
                .setServiceId(serviceId)
                .setItemId(itemId)
                .setQuantityUsed(quantityUsed)
                .setUnitPriceUsed(unitPriceUsed)
                .build();
    }
}
