import java.util.Scanner;

public class DistCalcEx2 {
    public static void main(String[] args) {
        // Declare variables
        double x1, y1, x2, y2, distance;
        
        // Read the coordinates of two points
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the x coordinate of point 1: ");
        x1 = scanner.nextDouble();
        System.out.print("Enter the y coordinate of point 1: ");
        y1 = scanner.nextDouble();
        System.out.print("Enter the x coordinate of point 2: ");
        x2 = scanner.nextDouble();
        System.out.print("Enter the y coordinate of point 2: ");
        y2 = scanner.nextDouble();
        
        // Calculate the distance between the two points
        distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        
        // Display the distance with three decimal places
        System.out.printf("The distance between the points is: %.3f%n", distance);
        
        // Close the scanner
        scanner.close();
    }
}
