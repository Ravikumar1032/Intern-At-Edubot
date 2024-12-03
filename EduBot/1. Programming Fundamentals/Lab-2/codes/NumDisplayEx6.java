import java.util.Scanner;

public class NumDisplayEx6 {
    public static void main(String[] args) {
        // Prompt the user to enter a number between 0 and 9
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 9: ");
        int num = scanner.nextInt();
        
        // Display the corresponding word using a switch statement
        switch (num) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
                break;
            default:
                System.out.println("Invalid number! Please enter a number between 0 and 9.");
        }
        
        // Close the scanner
        scanner.close();
    }
}
