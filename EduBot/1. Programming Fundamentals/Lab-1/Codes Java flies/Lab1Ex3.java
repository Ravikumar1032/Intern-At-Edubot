import java.util.Scanner;

public class Lab1Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age guess: ");
        int ageGuess = scanner.nextInt();
        
        System.out.println("Name: " + name);
        System.out.println("Age Guess: " + ageGuess);
        
        scanner.close();
    }
}
