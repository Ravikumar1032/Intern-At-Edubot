public class Ex4_OverrideSuper {
    public double calcArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calcArea(double length, double width) {
        return length * width;
    }

    public int calculate(int a, int b) {
        return a + b;
    }

    public double calculate(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        Ex4_OverrideSuper ex = new Ex4_OverrideSuper();
        System.out.println("Area of a circle with radius 5: " + ex.calcArea(5));
        System.out.println("Area of a rectangle with length 3 and width 4: " + ex.calcArea(3, 4));
        System.out.println("Sum of 10 and 15: " + ex.calculate(10, 15));
        System.out.println("Product of 2.5 and 3.5: " + ex.calculate(2.5, 3.5));
    }
}