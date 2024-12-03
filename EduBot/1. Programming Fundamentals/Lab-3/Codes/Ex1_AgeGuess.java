import java.util.Scanner;
import java.util.Random;

public class Ex1_AgeGuess {
    public static void main(String[] args) {
        // Declare and initialize variables
        int age;
        int ageGuess;
        
        // Generate a random age between 0 and 100 (inclusive)
        Random rand = new Random();
        age = rand.nextInt(101);
        
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Loop until the user guesses the correct age
        while (true) {
            // Ask the user for a guess
            System.out.print("Guess the age: ");
            ageGuess = scanner.nextInt();
            
            // Check if the guess is correct
            if (ageGuess == age) {
                System.out.println("Congratulations! You guessed the correct age: " + age);
                break; // Exit the loop if the guess is correct
            } else {
                System.out.println("Incorrect guess. Try again!");
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}
