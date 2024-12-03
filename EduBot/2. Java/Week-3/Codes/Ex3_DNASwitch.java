import java.util.Scanner;

public class Ex3_DNASwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder dnaSequence = new StringBuilder();

        int i = 0;
        while (i < 8) {
            System.out.println("Enter a single DNA nucleotide (A, C, G, T): ");
            String userInput = scanner.next();

            char dnaNucleotide = userInput.toUpperCase().charAt(0); // Convert input to uppercase

            switch (dnaNucleotide) {
                case 'A':
                    dnaSequence.append("Adenine ");
                    break;
                case 'C':
                    dnaSequence.append("Cytosine ");
                    break;
                case 'G':
                    dnaSequence.append("Guanine ");
                    break;
                case 'T':
                    dnaSequence.append("Thymine ");
                    break;
                default:
                    dnaSequence.append("Unknown ");
            }
            i++;
        }

        System.out.println("Final DNA sequence: " + dnaSequence.toString());

        scanner.close();
    }
}