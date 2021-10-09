import java.lang.*;
import java.util.*;
class ex1{
	public static void main(String args[]){
		System.out.print("Enter 2 Numbers:");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("The Sum of "+a+" and "+b+" is "+(a+b));
		System.out.println("The Subtract of "+a+" from "+b+" is "+(a-b));
		System.out.println("The Product of "+a+" and "+b+" is "+(a*b));
		System.out.println("The Division of "+a+" by "+b+" is "+(a/b));
		System.out.println("The Remainder of dividing "+a+" by "+b+" is "+(a%b));
	}
}