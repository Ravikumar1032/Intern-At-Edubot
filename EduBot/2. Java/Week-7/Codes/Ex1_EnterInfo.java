import java.util.Scanner;

class BlankNameException extends Exception {
    public BlankNameException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Ex1_EnterInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int age = 0;

        while (true) {
            try {
                System.out.println("Enter your name: ");
                name = scanner.nextLine();

                if (name.trim().isEmpty()) {
                    throw new BlankNameException("Name cannot be blank.");
                }

                System.out.println("Enter your age: ");
                String ageInput = scanner.nextLine();
                
                try {
                    age = Integer.parseInt(ageInput);
                    if (age <= 0 || age >= 120) {
                        throw new InvalidAgeException("Age must be between 1 and 119.");
                    }
                } catch (NumberFormatException e) {
                    throw new Exception("Invalid age entered. Please enter a valid integer value for age.");
                }

                break; // Break loop if valid name and age entered

            } catch (BlankNameException | InvalidAgeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        scanner.close();
    }
}