import java.lang.*;
import java.util.*;
class UserDefinedExceptionExample{
	public static void main(String args[]){
		try{
			System.out.print("Enter the Balance Amount:");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			if(a<1000)
				throw new MyException(a);
			System.out.println("Sufficient Base Amount");
		}catch(MyException e){
			System.out.println(e);
		}
	}
}
class MyException extends Exception{
	int a;
	MyException(int b) {
		a=b;
	}
	public String toString(){
		return ("Insufficient Base Amount");
	}
}