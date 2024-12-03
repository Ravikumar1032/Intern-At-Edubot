public class Numbers {

    public static void nextLargest(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            int nextLargestNum = Integer.MAX_VALUE;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > currentNum) {
                    nextLargestNum = numbers[j];
                    break;
                }
            }
            System.out.println(currentNum + ": " + (nextLargestNum == Integer.MAX_VALUE ? "2147483647" : nextLargestNum));
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {78, 22, 56, 99, 12, 14, 17, 15, 1, 144, 37, 23, 47, 88, 3, 19};
        nextLargest(inputArray);
    }
}