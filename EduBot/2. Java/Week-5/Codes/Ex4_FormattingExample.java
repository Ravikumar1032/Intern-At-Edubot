public class Ex4_FormattingExample {
    public static void main(String[] args) {
        double amt = 1234.56789;
        String firstName = "John";
        String lastName = "Doe";
        int birthDay = 1;
        String birthMonth = "June";
        int birthYear = 1901;

        System.out.printf("The amount is $%,.2f\n", amt);
        System.out.printf("My name is %s %s and I was born on %s %d, %d\n", firstName, lastName, birthMonth, birthDay, birthYear);
        System.out.printf("%s %s - %d\n", firstName, lastName, birthYear);
    }
}
