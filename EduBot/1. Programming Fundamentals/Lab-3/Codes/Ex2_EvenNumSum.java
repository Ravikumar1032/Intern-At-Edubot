import java.util.Scanner;

public class Ex2_EvenNumSum {
    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter an integer value
        System.out.print("Enter an integer value (>= 2): ");
        int input = scanner.nextInt();
        
        // Validate the input
        while (input < 2) {
            System.out.println("Error: Input value must be greater than or equal to 2.");
            System.out.print("Please re-enter an integer value (>= 2): ");
            input = scanner.nextInt();
        }
        
        // Calculate and print the sum of all even integers between 2 and the input value
        int sum = 0;
        for (int i = 2; i <= input; i += 2) {
            sum += i;
        }
        System.out.println("Sum of even integers between 2 and " + input + " (inclusive): " + sum);
        
        // Close the scanner
        scanner.close();
    }
}
