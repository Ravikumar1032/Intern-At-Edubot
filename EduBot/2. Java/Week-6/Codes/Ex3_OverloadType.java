public class Ex3_OverloadType {

    public int sum(int num1, float num2) {
        int roundedSum = Math.round(num1 + num2);
        System.out.println("Rounded sum of " + num1 + " and " + num2 + " is: " + roundedSum);
        return roundedSum;
    }

    public void sum(String str, int count) {
        System.out.print("Display - ");
        for (int i = 0; i < count; i++) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ex3_OverloadType ot = new Ex3_OverloadType();

        int roundedSum = ot.sum(10, 5.5f);
        ot.sum("SampleString", 3);
    }
}