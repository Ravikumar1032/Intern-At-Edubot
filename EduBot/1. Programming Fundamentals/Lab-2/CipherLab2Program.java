import java.util.Scanner;
import java.util.Random;

public class CipherLab2Program {
    public static void main(String[] args) {
        // Block comment with student information
        /*
        Name: [Your Name]
        Course: [Course Name]
        Semester: [Semester]
        Assignment: Programming Assignment 1 (Cipher)
        */

        // Welcome message
        System.out.println("Programming Fundamentals");
        System.out.println("NAME: RAVIKUMAR NAIK");
        System.out.println("PROGRAMMING ASSIGNMENT 1");
        System.out.println("Welcome to the Cipher program.");

        // Read 5 integers from the user
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Please enter the " + (i + 1) + "st number: ");
            numbers[i] = scanner.nextInt();
            // Check if the number is in the range [0, 19]
            if (numbers[i] < 0 || numbers[i] > 19) {
                System.out.println("Please read directions and try again!");
                System.exit(0); // Terminate the program
            }
        }

        // Calculate the total sum of the numbers
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Total = " + sum);

        // Generate a random key in the range [0, 9]
        Random rand = new Random();
        int key = rand.nextInt(10);
        System.out.println("Your random key is " + key);

        // Encode the sum using the Caesar Code
        int encodedNumber = encodeNumber(sum, key);
        System.out.println("Your encoded number is " + encodedNumber);

        // Close the scanner
        scanner.close();
    }

    // Method to encode a number using the Caesar Code
    public static int encodeNumber(int number, int key) {
        int onesPlace = (number % 10 + key) % 10;
        int tensPlace = ((number / 10) % 10 + key) % 10;
        return tensPlace * 10 + onesPlace;
    }
}
