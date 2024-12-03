import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermarket implements Serializable {
    private List<Item> items;
    private List<Customer> customers;
    private List<Bill> bills;

    public Supermarket() {
        items = new ArrayList<>();
        customers = new ArrayList<>();
        bills = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public Item findItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public Bill generateBill(Customer customer, List<Item> purchasedItems, int[] quantities) {
        Bill bill = new Bill();
        for (int i = 0; i < purchasedItems.size(); i++) {
            bill.addItem(purchasedItems.get(i), quantities[i]);
        }
        bills.add(bill);
        return bill;
    }

    public void displayBills() {
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }

    public void saveData(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    public static Supermarket loadData(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Supermarket) ois.readObject();
        }
    }

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSupermarket Billing System");
            System.out.println("1. Add Item");
            System.out.println("2. Add Customer");
            System.out.println("3. Generate Bill");
            System.out.println("4. Display Items");
            System.out.println("5. Display Customers");
            System.out.println("6. Display Bills");
            System.out.println("7. Save Data");
            System.out.println("8. Load Data");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double itemPrice = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int itemQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter item category: ");
                    String itemCategory = scanner.nextLine();
                    supermarket.addItem(new Item(itemName, itemPrice, itemQuantity, itemCategory));
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer contact details: ");
                    String customerContact = scanner.nextLine();
                    supermarket.addCustomer(new Customer(customerName, customerContact));
                    break;
                case 3:
                    System.out.print("Enter customer name for billing: ");
                    String billingCustomerName = scanner.nextLine();
                    Customer customer = supermarket.findCustomerByName(billingCustomerName);
                    if (customer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    List<Item> purchasedItems = new ArrayList<>();
                    List<Integer> quantities = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter item name to purchase (or 'done' to finish): ");
                        String purchasedItemName = scanner.nextLine();
                        if (purchasedItemName.equalsIgnoreCase("done")) {
                            break;
                        }
                        Item item = supermarket.findItemByName(purchasedItemName);
                        if (item == null) {
                            System.out.println("Item not found.");
                            continue;
                        }
                        System.out.print("Enter quantity: ");
                        int purchasedQuantity = scanner.nextInt();
                        scanner.nextLine(); // consume the newline
                        purchasedItems.add(item);
                        quantities.add(purchasedQuantity);
                    }
                    int[] quantitiesArray = quantities.stream().mapToInt(i -> i).toArray();
                    Bill bill = supermarket.generateBill(customer, purchasedItems, quantitiesArray);
                    System.out.println("Generated Bill: " + bill);
                    break;
                case 4:
                    supermarket.displayItems();
                    break;
                case 5:
                    supermarket.displayCustomers();
                    break;
                case 6:
                    supermarket.displayBills();
                    break;
                case 7:
                    System.out.print("Enter filename to save data: ");
                    String saveFilename = scanner.nextLine();
                    try {
                        supermarket.saveData(saveFilename);
                        System.out.println("Data saved successfully.");
                    } catch (IOException e) {
                        System.out.println("Failed to save data: " + e.getMessage());
                    }
                    break;
                case 8:
                    System.out.print("Enter filename to load data: ");
                    String loadFilename = scanner.nextLine();
                    try {
                        supermarket = Supermarket.loadData(loadFilename);
                        System.out.println("Data loaded successfully.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Failed to load data: " + e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
