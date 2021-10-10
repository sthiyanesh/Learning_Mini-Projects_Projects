import java.lang.*;
import java.util.*;

class ex2{
	public static void main(String args[]){
		System.out.print("Enter the Radius of Circle");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.printf("The Perimeter of Circle is %.4f \n",(float) 2*22/7*a);
		System.out.printf("The Area of Circle is %.4f \n",(float) 22/7*a*a);
	}
}