import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class OnlineCourierService {
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Delivery> deliveries = new HashMap<>();
    private ArrayList<DeliveryPerson> deliveryPersons = new ArrayList<>();
    private Random random = new Random();

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            if (name.length() > 100) throw new InvalidUserInputException("Name is too long.");

            System.out.println("Enter your address:");
            String address = scanner.nextLine();

            System.out.println("Enter your phone number:");
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.matches("\\d{10}")) throw new InvalidUserInputException("Invalid phone number format.");

            int userID = users.size() + 1;
            User user = new User(name, address, phoneNumber, userID);
            users.put(userID, user);
            System.out.println("User registered successfully: " + user);
        } catch (InvalidUserInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter user ID:");
            int userID = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            User user = users.get(userID);
            if (user == null) throw new InvalidUserInputException("User not found.");

            System.out.println("Enter item name:");
            String itemName = scanner.nextLine();

            System.out.println("Enter item weight:");
            double itemWeight = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Item item = new Item(itemName, itemWeight);
            DeliveryPerson deliveryPerson = findAvailableDeliveryPerson();
            if (deliveryPerson == null) throw new DeliveryAssignmentException("No delivery person available.");

            int deliveryID = generateDeliveryID();
            Delivery delivery = new Delivery(deliveryID, deliveryPerson, user, item, DeliveryStatus.PENDING);
            deliveries.put(deliveryID, delivery);
            deliveryPerson.setAvailability(false);
            System.out.println("Order placed successfully: " + delivery);
        } catch (InvalidUserInputException | DeliveryAssignmentException e) {
            System.err.println(e.getMessage());
        }
    }

    private DeliveryPerson findAvailableDeliveryPerson() {
        for (DeliveryPerson dp : deliveryPersons) {
            if (dp.isAvailable()) {
                return dp;
            }
        }
        return null;
    }

    private int generateDeliveryID() {
        return random.nextInt(100000);
    }

    public void updateDeliveryStatus(int deliveryID, DeliveryStatus status) {
        Delivery delivery = deliveries.get(deliveryID);
        if (delivery != null) {
            delivery.setStatus(status);
            if (status == DeliveryStatus.DELIVERED) {
                delivery.getDeliveryPerson().setAvailability(true);
            }
            System.out.println("Delivery status updated: " + delivery);
        } else {
            System.err.println("Delivery not found.");
        }
    }

    public void trackDelivery(int deliveryID) {
        Delivery delivery = deliveries.get(deliveryID);
        if (delivery != null) {
            System.out.println("Delivery status: " + delivery.getStatus());
        } else {
            System.err.println("Delivery not found.");
        }
    }

    public static void main(String[] args) {
        OnlineCourierService service = new OnlineCourierService();
        service.deliveryPersons.add(new DeliveryPerson("John Doe", 1, true));
        service.deliveryPersons.add(new DeliveryPerson("Jane Smith", 2, true));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register User");
            System.out.println("2. Place Order");
            System.out.println("3. Track Delivery");
            System.out.println("4. Update Delivery Status");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    service.registerUser();
                    break;
                case 2:
                    service.placeOrder();
                    break;
                case 3:
                    System.out.println("Enter delivery ID:");
                    int deliveryID = scanner.nextInt();
                    service.trackDelivery(deliveryID);
                    break;
                case 4:
                    System.out.println("Enter delivery ID:");
                    deliveryID = scanner.nextInt();
                    System.out.println("Enter new status (0: PENDING, 1: IN_TRANSIT, 2: DELIVERED):");
                    int status = scanner.nextInt();
                    service.updateDeliveryStatus(deliveryID, DeliveryStatus.values()[status]);
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Invalid choice.");
            }
        }
    }
}
