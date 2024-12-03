import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private String contactDetails;

    public Customer(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', contactDetails='" + contactDetails + "'}";
    }
}
