public class Ex3_MyFibonacci {
	
    public static void main(String a[]){
        
        int febCount = 20;
        int[] feb = new int[febCount];
       
		feb[0] = 0;
		feb[1] = 1;
		

        for (int i = 2; i < febCount; i++) {
            feb[i] = feb[i - 1] + feb[i - 2];
        }

        for (int num : feb) {
            System.out.print(num + " ");
        }
   }

}