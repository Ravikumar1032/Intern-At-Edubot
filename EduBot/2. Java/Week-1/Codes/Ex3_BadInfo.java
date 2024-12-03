public class Ex3_BadInfo {
    // Variables
    private String age; // Changed to String
    private int firstName; // Changed to int

    // Constructor
    public Ex3_BadInfo(String age, int firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public void printInfo() {
        System.out.println("Age is "+ age +" First Name is "+ firstName);
    }


    // Main method for testing
    public static void main(String[] args) {
        // Creating object with incorrect values
        Ex3_BadInfo bad = new Ex3_BadInfo("twenty", 7);
	bad.printInfo();
    }
}
