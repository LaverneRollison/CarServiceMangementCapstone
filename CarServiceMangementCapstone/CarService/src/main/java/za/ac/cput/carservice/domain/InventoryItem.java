package za.ac.cput.carservice.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "inventoryItem")
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
   private String itemName;
    private int quantity;
    private double price;
  private int lowStock;

    private InventoryItem(Builder builder) {
        this.itemId=builder.itemId;
        this.itemName=builder.itemName;
        this.quantity=builder.quantity;
        this.price=builder.price;
        this.lowStock=builder.lowStock;
    }

    public InventoryItem() {

    }

    public int getItemId() {
        return itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public int getLowStock() {
        return lowStock;
    }

    public static class Builder {
        private int itemId;
        private String itemName;
        private int quantity;
        private double price;
        private int lowStock;

        public Builder setItemId(int itemId) {
            this.itemId = itemId;
            return this;
        }
        public Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;

        }
        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }
        public Builder setLowStock(int lowStock) {
            this.lowStock = lowStock;
            return this;
        }

        public InventoryItem.Builder copy(InventoryItem inventoryItem) {
            this.itemId=inventoryItem.itemId;
            this.itemName=inventoryItem.itemName;
            this.quantity=inventoryItem.quantity;
            this.price=inventoryItem.price;
            this.lowStock=inventoryItem.lowStock;
            return this;
        }


        public InventoryItem build() {
            return new InventoryItem(this);
        }
        }
        @Override
        public String toString() {
            return "InventoryItem{"+
                    "itemId:"+ itemId+ "/"+
                    "itemName:"+ itemName+"/"+
                    "quantity:"+ quantity+"/"+
                    "price:"+price+"/"+
                    "lowStock:"+lowStock+"}";


    }
}
