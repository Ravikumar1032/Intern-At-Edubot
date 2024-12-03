public class Lab1Ex2 {
    public static void main(String[] args) {
        double quizScore1 = 80.5;
        double quizScore2 = 75.0;
        double quizScore3 = 90.0;
        double testScore1 = 85.5;
        double testScore2 = 88.0;
        
        double quizScoreAvg = (quizScore1 + quizScore2 + quizScore3) / 3;
        double testScoreAvg = (testScore1 + testScore2) / 2;
        
        System.out.println("Quiz Score Average: " + quizScoreAvg);
        System.out.println("Test Score Average: " + testScoreAvg);
    }
}
