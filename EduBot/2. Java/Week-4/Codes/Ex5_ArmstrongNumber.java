import java.util.Scanner;

public class Ex5_ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to check if it is an Armstrong number:");
        int number = scanner.nextInt();

        int originalNumber = number;
        int totalDigits = String.valueOf(number).length();
        int armstrong = 0;

        while (number > 0) {
            int digit = number % 10;
            armstrong += Math.pow(digit, totalDigits);
            number /= 10;
        }

        if (originalNumber == armstrong) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }

        scanner.close();
    }
}