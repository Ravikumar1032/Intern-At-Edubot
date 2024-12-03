import java.util.Random;

public class Ex6_RectangleDisplay {

    public static void main(String[] args) {
        int width = 4;
        int height = 3;

        System.out.println("Rectangle:");
        displayRectangle(width, height);

        System.out.println("Is the rectangle 'Silly'? " + isSilly(width, height));
        System.out.println("Diagonal of the rectangle: " + diagonal(width, height));
        System.out.println("A random rectangle:");
        randomRe();
    }

    public static void displayRectangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static boolean isSilly(int width, int height) {
        return width == height;
    }

    public static double diagonal(int width, int height) {
        return Math.sqrt((width * width) + (height * height));
    }

    public static void randomRe() {
        Random random = new Random();
        int randWidth = random.nextInt(10) + 1; // Random width between 1 and 10
        int randHeight = random.nextInt(10) + 1; // Random height between 1 and 10

        displayRectangle(randWidth, randHeight);
    }
}