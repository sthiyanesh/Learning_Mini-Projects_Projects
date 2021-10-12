import java.lang.*;
import java.util.*;
class select2{
	public static void main(String args[]){
		System.out.print("Enter Your Grade:");
		Scanner s = new Scanner(System.in);
		
        char c = s.next().charAt(0);
		switch(c)
		{
			case 'A':
			    System.out.print("Bonus for Grade A employee is:2,000");
				break;
			case 'B':
			    System.out.print("Bonus for Grade B employee is:1,500");
				break;
			case 'C':
				System.out.print("Bonus for Grade C employee is:1,250");
				break;
			case 'D':
			    System.out.print("Bonus for Grade D employee is:1,000");
				break;
			case 'E':
			    System.out.print("Bonus for Grade E employee is:500");
				break;
			default:
				System.out.print("Out Grade Range A to E.Bonus for Grade "+c+" is 50");
				break;
		}
	}
}