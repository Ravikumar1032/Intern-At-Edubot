public class FloatEquEx5 {
    public static void main(String[] args) {
        // Declare and initialize variables
        double var1 = (1.0 / 10) * (1.0 / 10);
        double var2 = 1.0 / 100;
        
        // Check if the variables are equal
        if (var1 == var2) {
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT EQUAL");
        }
        
        // Check if the variables are approximately equal
        double tolerance = 0.0001;
        if (Math.abs(var1 - var2) < tolerance) {
            System.out.println("APPROXIMATELY EQUAL");
        } else {
            System.out.println("NOT APPROXIMATELY EQUAL");
        }
    }
}
