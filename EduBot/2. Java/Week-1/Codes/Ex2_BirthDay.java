public class Ex2_BirthDay {
    // Variables
    private int birthMonth;
    private int birthDay;
    private int birthYear;

    // Constructor
    public Ex2_BirthDay(int birthMonth, int birthDay, int birthYear) {
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    // Print method
    public void printBirthdays() {
        // USA Format
        System.out.println("In the USA my birthday is: " + birthMonth + "/" + birthDay + "/" + birthYear);
        // UK Format
        System.out.println("In England my birthday is: " + birthDay + "/" + birthMonth + "/" + birthYear);
    }

    // Main method for testing
    public static void main(String[] args) {
        Ex2_BirthDay myBirthday = new Ex2_BirthDay(03, 26, 2003);
        myBirthday.printBirthdays();
        // Changing variables for friend's birthday
        Ex2_BirthDay friendBirthday = new Ex2_BirthDay(4, 8, 2004);
        System.out.println("In the USA my friend Sajida's birthday is: " + friendBirthday.birthMonth + "/" + friendBirthday.birthDay + "/" + friendBirthday.birthYear);
        System.out.println("In England my friend Sajida's birthday is: " + friendBirthday.birthDay + "/" + friendBirthday.birthMonth + "/" + friendBirthday.birthYear);
    }
}
