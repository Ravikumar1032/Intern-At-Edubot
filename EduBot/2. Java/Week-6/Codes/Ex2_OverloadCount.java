public class Ex2_OverloadCount {
    
    public int find(int a, int b, int c, int d) {
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        System.out.println("The largest number is: " + max);
        return max;
    }

    public int find(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        System.out.println("The smallest number is: " + min);
        return min;
    }

    public double find(int a) {
        double squareRoot = Math.round(Math.sqrt(a) * 10.0) / 10.0;
        System.out.println("The square root of the number is: " + squareRoot);
        return squareRoot;
    }

    public static void main(String[] args) {
        Ex2_OverloadCount oc = new Ex2_OverloadCount();

        int largest = oc.find(20, 5, 10, 30);
        int smallest = oc.find(7, 20, 4);
        double squareRoot = oc.find(25);
    }
}