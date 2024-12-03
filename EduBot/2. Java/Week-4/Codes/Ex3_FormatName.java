import java.util.Scanner;

public class Ex3_FormatName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name in the format FIRST.MIDDLE.LAST:");
        String inputName = scanner.nextLine();

        String[] nameParts = inputName.split("\\.");

        if(nameParts.length != 3) {
            System.out.println("Incorrect format. Please enter the name in the format FIRST.MIDDLE.LAST");
            return;
        }
        
        String firstName = nameParts[0];
        String middleName = nameParts[1];
        String lastName = nameParts[2];
        char middleInitial = middleName.charAt(0);

        String formattedName = lastName.toUpperCase() + ", " + firstName + " " + middleInitial + ".";

        System.out.println("Formatted Name: " + formattedName);

        scanner.close();
    }
}