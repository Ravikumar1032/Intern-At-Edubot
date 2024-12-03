public class DeliveryPerson {
    private String name;
    private int ID;
    private boolean availability;

    public DeliveryPerson(String name, int ID, boolean availability) {
        this.name = name;
        this.ID = ID;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", availability=" + availability +
                '}';
    }
}
