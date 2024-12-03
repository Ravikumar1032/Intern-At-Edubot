public class Delivery {
    private int deliveryID;
    private DeliveryPerson deliveryPerson;
    private User user;
    private Item item;
    private DeliveryStatus status;

    public Delivery(int deliveryID, DeliveryPerson deliveryPerson, User user, Item item, DeliveryStatus status) {
        this.deliveryID = deliveryID;
        this.deliveryPerson = deliveryPerson;
        this.user = user;
        this.item = item;
        this.status = status;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryID=" + deliveryID +
                ", deliveryPerson=" + deliveryPerson +
                ", user=" + user +
                ", item=" + item +
                ", status=" + status +
                '}';
    }
}
