import java.util.Scanner;

public class Ex4_StudentLetterGrade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking user for student information
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter weekly grade points: ");
        float weeklyGradePoints = scanner.nextFloat();

        System.out.print("Enter final exam points: ");
        float finalExamPoints = scanner.nextFloat();

        // Computing final grade
        float finalGrade = weeklyGradePoints + finalExamPoints;

        // Determining the letter grade using a switch statement
        char letterGrade;
        switch ((int)finalGrade / 10) {
            case 10:
                letterGrade = 'A';
                break;
            case 9:
                letterGrade = 'A';
                break;
            case 8:
                letterGrade = 'B';
                break;
            case 7:
                letterGrade = 'C';
                break;
            case 6:
                letterGrade = 'D';
                break;
            default:
                letterGrade = 'F';
        }

        // Displaying the final grade and letter grade
        System.out.println("Student " + studentID + " earned a grade of " + finalGrade + " / " + letterGrade);

        scanner.close();
    }
}