import java.lang.*;
import java.util.*;
class iterate2{
	public static void main(String args[]){
		System.out.println("Floyd's Trianlge:");
		System.out.print("Enter the Number of Lines:");
		Scanner S = new Scanner(System.in);
		int n = S.nextInt();
		int cnt=1;
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				System.out.print(cnt+" ");
				cnt++;
			}
			System.out.println();
		}
	}
}