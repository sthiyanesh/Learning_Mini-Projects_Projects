import java.lang.*;
import java.lang.Math.*;
import java.util.*;
class select1{
	public static void main(String args[]){
		System.out.println("Let the Quadratic Equation be ax^2+bX+c=0");
		System.out.print("Enter the value of A:");
		Scanner s = new Scanner(System.in);
		double a = s.nextDouble();
		System.out.print("Enter the value of b:");
		double b = s.nextDouble();
		System.out.print("Enter the value of c:");
		double c = s.nextDouble();
		double d = b*b-4.0*a*c;
		double res1,res2;
		if(d>0){
			System.out.println("The Roots are Different.");
			res1 = (-b+Math.sqrt(d))/(2.0*a);
			res2 = (-b-Math.sqrt(d))/(2.0*a);
			System.out.println("The Roots are "+res1+" and "+res2);
		}else if(d==0){
			System.out.println("The Roots are Same and Equal.");
			res1 = -b/(2.0*a);
			System.out.println("The Root is "+res1);
		}else{
			System.out.println("The Roots are not Real");
		}
		
	}
}