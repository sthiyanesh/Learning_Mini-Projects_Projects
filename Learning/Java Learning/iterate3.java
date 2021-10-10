import java.lang.*;
import java.util.*;
class iterate3{
	public static void main(String args[]){
		System.out.println("Enter 10 Integer");
		Scanner S = new Scanner(System.in);
		int[] arr = new int[10];
		int n=10,i=0;
		do{
			arr[i] = S.nextInt();
			i++;
		}while(i<n);
		System.out.println("The Enterd 10 numbers are...");
		i=0;
		do{
			System.out.print(arr[i]+" ");
			i++;
		}while(i<n);
	}
}