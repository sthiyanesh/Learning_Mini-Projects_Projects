import java.lang.*;
import java.util.*;
class iterate1{
	public static void main(String args[]){
		System.out.println("Fibonacci Series:");
		System.out.print("Enter the Number of terms:");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int a1=1;
		int a2=1;
		System.out.println("1\n1");
		a-=2;
		while((a--)!=0){
			int temp = a1+a2;
			System.out.println(temp);
			a1=a2;
			a2=temp;
		}
	}
}