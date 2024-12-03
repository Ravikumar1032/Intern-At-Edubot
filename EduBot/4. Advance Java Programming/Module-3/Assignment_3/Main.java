import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = null;

        try {
            userDAO = new PostgreSQLUserDAO();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Display All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
                    userDAO.addUser(name, email);
                    System.out.println("User added successfully!");
                    break;
                case 2:
                    userDAO.getAllUsers();
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.next();
                    userDAO.updateUser(idToUpdate, newName, newEmail);
                    System.out.println("User updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    int idToDelete = scanner.nextInt();
                    userDAO.deleteUser(idToDelete);
                    System.out.println("User deleted successfully!");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
