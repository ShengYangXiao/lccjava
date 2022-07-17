package d0717;

public class HW3 {
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("請在1~100間輸入一個數字");
		int num = scan.nextInt();
		for(int i=1;i<=num;i++) {
			if(num%i==0) {
				System.out.print(i+",");
			}
		}
		System.out.println("為"+num+"的因數");
	}

}
