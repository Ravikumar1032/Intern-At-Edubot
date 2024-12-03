import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add user");
            System.out.println("2. Update user by ID");
            System.out.println("3. List all users");
            System.out.println("4. Find user by name");
            System.out.println("5. List users sorted by name");
            System.out.println("6. Remove user by ID");
            System.out.println("7. Exit");

            System.out.print("Enter Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user email: ");
                    String email = scanner.nextLine();
                    userManager.addUser(new User(id, name, email));
                    System.out.println("Successfully added!\n");
                    break;
                case 2:
                    System.out.print("Enter user ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new user name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new user email: ");
                    String newEmail = scanner.nextLine();
                    userManager.updateUserById(updateId, new User(null, newName, newEmail));
                    System.out.println("Successfully Updated!\n");
                    break;
                case 3:
                    System.out.println("All users:");
                    userManager.listAllUsers();
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    System.out.println("Users with name '" + searchName + "':");
                    userManager.findUserByName(searchName).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Users sorted by name:");
                    userManager.listUsersSortedByName().forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Enter user ID to remove: ");
                    int removeId = scanner.nextInt();
                    userManager.removeUserById(removeId);
                    System.out.println("Successfully Removed!\n");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
