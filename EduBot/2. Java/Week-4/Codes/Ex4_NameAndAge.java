import java.util.Scanner;
import java.time.Year;
import java.time.LocalDate;

public class Ex4_NameAndAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your year of birth:");
        int yearOfBirth = scanner.nextInt();

        int totalCharactersInName = firstName.length();

        int currentYear = Year.now().getValue();
        int age = currentYear - yearOfBirth;

        System.out.println("There are " + totalCharactersInName + " characters in " + firstName + "'s name.");
        System.out.println(firstName + " will be " + age + " years old in " + currentYear + ".");

        scanner.close();
    }
}