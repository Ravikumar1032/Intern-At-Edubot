import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Item(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', price=" + price + ", quantity=" + quantity + ", category='" + category + "'}";
    }
}
