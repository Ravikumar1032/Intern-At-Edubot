import java.util.Scanner;

public class Ex2_ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a 3-digit number to check if it is an Armstrong number:");
        int number = scanner.nextInt();

        if (number < 100 || number > 999) {
            System.out.println("Number is not a 3-digit number.");
        } else {
            int originalNumber = number;
            int armstrong = 0;
            int digit;

            while (number > 0) {
                digit = number % 10;
                armstrong += Math.pow(digit, 3);
                number /= 10;
            }

            if (originalNumber == armstrong) {
                System.out.println(originalNumber + " is an Armstrong number.");
            } else {
                System.out.println(originalNumber + " is not an Armstrong number.");
            }
        }

        scanner.close();
    }
}