import java.util.Scanner;

public class DivisorCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first positive integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second positive integer: ");
        int num2 = scanner.nextInt();
        System.out.println("The greatest common divisor of " + num1 + " and " + num2 + " is: " + gcd(num1, num2));
        scanner.close();
    }

    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return gcd(num2, num1 % num2);
        }
    }
}
