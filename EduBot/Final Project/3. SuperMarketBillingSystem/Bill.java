import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private List<Item> items;
    private double totalAmount;

    public Bill() {
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(Item item, int quantity) {
        items.add(item);
        totalAmount += item.getPrice() * quantity;
        item.setQuantity(item.getQuantity() - quantity);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bill{items=");
        for (Item item : items) {
            sb.append(item.toString()).append(", ");
        }
        sb.append("totalAmount=").append(totalAmount).append('}');
        return sb.toString();
    }
}
