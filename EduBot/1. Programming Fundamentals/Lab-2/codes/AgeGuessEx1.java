import java.util.Scanner;
import java.util.Random;

public class AgeGuessEx1 {
    public static void main(String[] args) {
        // Declare and initialize variables
        int age;
        int ageGuess;
        
        // Generate a random age between 0 and 100 (inclusive)
        Random rand = new Random();
        age = rand.nextInt(101);
        
        // Ask the user for a guess
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess the age: ");
        ageGuess = scanner.nextInt();
        
        // Display the user's guess and the correct answer
        System.out.println("Your guess: " + ageGuess);
        System.out.println("Correct answer: " + age);
        
        // Close the scanner
        scanner.close();
    }
}
