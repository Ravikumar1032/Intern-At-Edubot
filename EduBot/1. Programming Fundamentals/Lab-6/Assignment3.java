import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programming Fundamentals");
        System.out.println("Program #3");
        System.out.println("Name:Mahmood Sajida");
        System.out.println("Fall 2021");
        System.out.println("***********************");

        // Loop to keep asking for input until -1 is entered
        while (true) {
            System.out.println("Please enter a number:");
            int number = scanner.nextInt();
            if (number == -1) {
                System.out.println("Goodbye!");
                break;
            }
            boolean hasOdd = hasAnOddDigit(number);
            int sum = sumOfDigits(number, hasOdd);
            if (hasOdd) {
                System.out.println("True. The number has at least one odd digit. The sum of the odd digits is " + sum);
            } else {
                System.out.println("False. The number has no odd digits. The sum of the even digits is " + sum);
            }
        }
        scanner.close();
    }

    public static boolean hasAnOddDigit(int number) {
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    public static int sumOfDigits(int number, boolean odd) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            if ((odd && digit % 2 != 0) || (!odd && digit % 2 == 0)) {
                sum += digit;
            }
            number /= 10;
        }
        return sum;
    }
}

