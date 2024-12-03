import java.util.Scanner;

public class Ex3_VowelCounter {
    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Initialize counters for vowels and non-vowels
        int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0, nonVowelCount = 0;
        
        // Convert the input string to lowercase for case-insensitive comparison
        input = input.toLowerCase();
        
        // Iterate through each character in the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // Increment the respective vowel counter
            switch (ch) {
                case 'a':
                    aCount++;
                    break;
                case 'e':
                    eCount++;
                    break;
                case 'i':
                    iCount++;
                    break;
                case 'o':
                    oCount++;
                    break;
                case 'u':
                    uCount++;
                    break;
                default:
                    // Increment the non-vowel counter for any other character
                    nonVowelCount++;
                    break;
            }
        }
        
        // Print the counts of each vowel and non-vowel
        System.out.println("Number of 'a's: " + aCount);
        System.out.println("Number of 'e's: " + eCount);
        System.out.println("Number of 'i's: " + iCount);
        System.out.println("Number of 'o's: " + oCount);
        System.out.println("Number of 'u's: " + uCount);
        System.out.println("Number of non-vowel characters: " + nonVowelCount);
        
        // Close the scanner
        scanner.close();
    }
}
