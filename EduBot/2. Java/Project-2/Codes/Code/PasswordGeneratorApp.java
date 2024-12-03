import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordGeneratorApp {

    private static final Logger LOGGER = Logger.getLogger(PasswordGeneratorApp.class.getName());
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        FileHandler fileHandler = new FileHandler();
        UserInput userInput = new UserInput(scanner);

        boolean exit = false;

        while (!exit) {
            System.out.println("Password Generator Menu:");
            System.out.println("1. Generate Passwords");
            System.out.println("2. Save Passwords to File");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = userInput.getValidIntInput();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of passwords to generate: ");
                    int numPasswords = userInput.getValidIntInput();
                    System.out.print("Enter the desired password length (8-20): ");
                    int passwordLength = userInput.getValidIntInput(MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH);
                    String[] passwords = passwordGenerator.generatePasswords(numPasswords, passwordLength);
                    System.out.println("Generated Passwords:");
                    for (String password : passwords) {
                        System.out.println(password);
                    }
                    break;
                case 2:
                    System.out.print("Enter the file name to save passwords: ");
                    String fileName = scanner.next();
                    try {
                        fileHandler.savePasswordsToFile(passwordGenerator.getGeneratedPasswords(), fileName);
                        System.out.println("Passwords saved to " + fileName);
                    } catch (Exception e) {
                        LOGGER.log(Level.SEVERE, "Error saving passwords to file", e);
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
