import java.util.Scanner;

public class A3_Employee {
    private String name;
    private int age;
    private double salary;

    public static void main(String[] args) {
        A3_Employee employee = new A3_Employee();
        employee.acceptInput();
        employee.validateInput();
    }

    public void acceptInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee name:");
        name = scanner.nextLine();

        System.out.println("Enter employee age:");
        age = scanner.nextInt();

        System.out.println("Enter employee salary:");
        salary = scanner.nextDouble();
    }

    public void validateInput() {
        if (name.isBlank()) {
            System.out.println("Name cannot be blank. Please provide a valid name.");
        } else if (age <= 0 || age >= 120) {
            System.out.println("Age should be greater than 0 and less than 120. Please provide a valid age.");
        } else if (salary <= 0) {
            System.out.println("Salary should be greater than 0. Please provide a valid salary.");
        } else {
            System.out.println("Input successful: Name - " + name + ", Age - " + age + ", Salary - " + String.format("%.2f", salary));
        }
    }
}