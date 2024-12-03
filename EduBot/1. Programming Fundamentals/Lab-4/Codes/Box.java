public class Box {
    int size = 0;

    public void printBox() {
        printBox('*');
    }

    public void printBox(char c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Box box = new Box();
        box.size = 5;
        box.printBox();
        box.printBox('@'); // Using the overloaded method with a different character
    }
}