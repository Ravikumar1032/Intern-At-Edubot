import java.util.Scanner;

public class Ex1_ConvertPounds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter weight in pounds:");
        double pounds = scanner.nextDouble();

        double kilograms = convertIt(pounds);
        
        System.out.println(pounds + " pounds is equal to " + kilograms + " kilograms.");

        scanner.close();
    }

    public static double convertIt(double pounds) {
        double kilograms = pounds * 0.453592;
        return kilograms;
    }
}