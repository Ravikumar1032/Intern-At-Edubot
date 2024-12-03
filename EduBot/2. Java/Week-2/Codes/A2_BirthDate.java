
import java.util.Scanner;

public class A2_BirthDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the birth month:");
        int month = scanner.nextInt();
        System.out.println("Enter the birth day:");
        int day = scanner.nextInt();
        System.out.println("Enter the birth year:");
        int year = scanner.nextInt();

        if (month > 0 && month < 13 && day > 0 && day < 32 && year > 1920 && year < 2020) {
            System.out.println("Valid birth date entered: " + month + "/" + day + "/" + year);
        } else {
            System.out.println("Invalid birth date entered. Please check the values.");
        }
    }
}