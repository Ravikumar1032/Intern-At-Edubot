import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter("userStrings.txt"))) {

            System.out.println("Enter strings (Enter 'DONE' to finish):");
            String input;

            while (!(input = scanner.nextLine()).equals("DONE")) {
                writer.write(input);
                writer.newLine();
            }
            System.out.println("Strings have been written to userStrings.txt.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}