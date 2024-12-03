import java.util.Scanner;
import java.util.Random;

public class UserNamesEx3 {
    public static void main(String[] args) {
        // Read the user's first and last name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        
        // Generate a random number between 10 and 99
        Random rand = new Random();
        int randomNumber = rand.nextInt(90) + 10;
        
        // Construct the username
        String username = lastName.substring(0, 4) + firstName.charAt(0) + randomNumber;
        
        // Print the username
        System.out.println("Your username is: " + username);
        
        // Close the scanner
        scanner.close();
    }
}
