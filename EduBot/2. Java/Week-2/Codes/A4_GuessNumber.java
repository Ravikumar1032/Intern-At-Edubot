import java.util.Scanner;
import java.util.Random;

public class A4_GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int randomNum = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int userGuess;
        int attempts = 0;
        
        System.out.println("Guess a number between 1 and 100:");

        do {
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < randomNum) {
                System.out.println("Too low. Guess again:");
            } else if (userGuess > randomNum) {
                System.out.println("Too high. Guess again:");
            } else {
                System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
            }

        } while (userGuess != randomNum);
        
        scanner.close();
    }
}