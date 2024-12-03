import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getValidIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    public int getValidIntInput(int min, int max) {
        while (true) {
            int input = getValidIntInput();
            if (input >= min && input <= max) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter an integer between " + min + " and " + max + ".");
            }
        }
    }
}
