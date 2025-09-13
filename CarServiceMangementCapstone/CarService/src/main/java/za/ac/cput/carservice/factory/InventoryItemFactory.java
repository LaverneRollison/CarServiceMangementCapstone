package za.ac.cput.carservice.factory;

import za.ac.cput.carservice.domain.InventoryItem;


public class InventoryItemFactory {

    public static InventoryItem createInventoryItem(
            String itemName,
            int quantity,
            double price,
            int lowStock) {


        if (itemName == null || itemName.isEmpty())
            throw new IllegalArgumentException("Item name is required");

        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative");

        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");

        if (lowStock < 0)
            throw new IllegalArgumentException("Low stock value cannot be negative");


        return new InventoryItem.Builder()
                .setItemName(itemName)
                .setQuantity(quantity)
                .setPrice(price)
                .setLowStock(lowStock)
                .build();
    }
}
