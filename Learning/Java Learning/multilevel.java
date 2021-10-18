import java.lang.*;
import java.util.*;
class animal{
	public String getName(){
		return "Accessing the Method of Animal class";
	}
}
class Mammal extends animal{
	public String getname(){
		return "Accessing the Method of Mammal Class";
	}
}
class Dog extends Mammal{
	
}
class multilevel{
	public static void main(String args[]){
		Dog d = new Dog();
		System.out.println("Checking d is instance of Mammal:"+(d instanceof Mammal));
		System.out.println("Checking d is instance of animal:"+(d instanceof animal));
		System.out.println(d.getname());
		System.out.println(d.getName());
	}
}