
public class HW1 {

	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		System.out.println("Please key in a number");
		
		int num = scan.nextInt();
		int A = num%2;
		
		if (A == 0) {
			System.out.println(num+" is even");
	    }else{
			System.out.println(num+" is odd");
			}
	  }		
}
