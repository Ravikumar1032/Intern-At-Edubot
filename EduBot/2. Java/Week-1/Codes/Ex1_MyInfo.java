public class Ex1_MyInfo {
    // Variables
    private int age;
    private String firstName;
    private String lastName;
    private String birthCity;

    // Constructor
    public Ex1_MyInfo(int age, String firstName, String lastName, String birthCity) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthCity = birthCity;
    }

    // Print method
    public void printInfo() {
        System.out.println("My Name is " + firstName + " " + lastName + ".");
        System.out.println("I am " + age + " years old and was born in " + birthCity + ".");
    }

    // Main method for testing
    public static void main(String[] args) {
        Ex1_MyInfo info = new Ex1_MyInfo(21, "Mary", "Jones", "Cleveland");
        info.printInfo();
    }
}
