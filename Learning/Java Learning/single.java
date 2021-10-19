import java.lang.*;
import java.util.*;
class animal{
	public String getName(){
		return "Accessing the Method of Animal";
	}
}
class Dog extends animal{
	
}
public class single{
	public static void main(String args[]){
		Dog d = new Dog();
		System.out.println("Checking d is instance of animal:"+(d instanceof animal));
		System.out.println(d.getName());
	}
}