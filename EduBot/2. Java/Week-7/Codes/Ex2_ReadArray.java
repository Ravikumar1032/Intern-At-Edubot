public class Ex2_ReadArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        try {
            // Try block to read an element from the array
            System.out.println("Element at index 3: " + arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch block to handle ArrayIndexOutOfBoundsException
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            // Finally block to print a message that the operation is complete
            System.out.println("Operation is complete.");
        }
    }
}