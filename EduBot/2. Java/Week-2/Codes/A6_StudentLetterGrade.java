import java.util.Scanner;

public class A6_StudentLetterGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student ID:");
        String studentId = scanner.nextLine();

        System.out.println("Enter weekly grade points:");
        float weeklyGrade = scanner.nextFloat();

        System.out.println("Enter final exam points:");
        float finalExam = scanner.nextFloat();
        
        float finalGrade = weeklyGrade + finalExam;

        String letterGrade;
        if (finalGrade >= 93) {
            letterGrade = "A";
        } else if (finalGrade >= 90) {
            letterGrade = "A-";
        } else if (finalGrade >= 87) {
            letterGrade = "B+";
        } else if (finalGrade >= 83) {
            letterGrade = "B";
        } else if (finalGrade >= 80) {
            letterGrade = "B-";
        } else if (finalGrade >= 77) {
            letterGrade = "C+";
        } else if (finalGrade >= 73) {
            letterGrade = "C";
        } else if (finalGrade >= 70) {
            letterGrade = "C-";
        } else if (finalGrade >= 67) {
            letterGrade = "D+";
        } else if (finalGrade >= 63) {
            letterGrade = "D";
        } else if (finalGrade >= 60) {
            letterGrade = "D-";
        } else if (finalGrade >= 0) {
            letterGrade = "F";
        } else {
            System.out.println("Error: Final grade is out of range");
            return;
        }

        System.out.println("Student " + studentId + " earned a grade of " + finalGrade + " / " + letterGrade + ".");
        
        scanner.close();
    }
}