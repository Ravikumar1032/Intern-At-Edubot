public class Box {
    int size = 0;

    public static void main(String[] args) {
        // Create a Box object
        Box box = new Box();

        // Set the size of the box
        box.size = 5;

        // Invoke the printBox method
        box.printBox();
    }

    // Method to print a box of stars
    public void printBox() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
