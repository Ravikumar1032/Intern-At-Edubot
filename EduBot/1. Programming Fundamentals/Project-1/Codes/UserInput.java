import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of passwords to generate:");
        int numberOfPasswords = getIntInput(scanner);

        System.out.println("Enter the length of each password:");
        int passwordLength = getIntInput(scanner);

        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < numberOfPasswords; i++) {
            passwords.add(PasswordGenerator.generatePassword(passwordLength));
        }

        System.out.println("Generated passwords:");
        for (String password : passwords) {
            System.out.println(password);
        }

        System.out.println("Enter the filename to save the passwords:");
        String filename = scanner.next();

        try {
            FileHandler.savePasswordsToFile(passwords, filename);
            System.out.println("Passwords saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving passwords to file: " + e.getMessage());
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
