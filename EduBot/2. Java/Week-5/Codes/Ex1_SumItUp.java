public class Ex1_SumItUp {
	
	int x;
	int y;
	
	public void setSum( int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void showSum(){
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("sum  = " + (x+y) );
	}

	public static void main(String[] args) {
		
		Ex1_SumItUp sumMe = new Ex1_SumItUp();
		sumMe.setSum(2, 4);
		sumMe.showSum();
	}
}