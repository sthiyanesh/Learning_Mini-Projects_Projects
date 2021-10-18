import java.lang.*;
import java.util.*;
class animal{
	public int count;
	public String getName(){
		return "Accessing the method of Animal Class";
	}
}
class Dog extends animal{
	Dog(int count){
		super.count = count;
	}
}
class Cat extends animal{
	Cat(int count){
		super.count = count;
	}
}
class multiple{
	public static void main(String Args[]){
		Dog d = new Dog(10);
		Cat c = new Cat(8);
		System.out.println("The Count of Dog is "+d.count);
		System.out.println("The Count of Cat is "+c.count);
		System.out.println("Checking d is instance of animal:"+(d instanceof animal));
		System.out.println("Checking c is instance of animal:"+(c instanceof animal));
		System.out.println(d.getName()+" via d object");
		System.out.println(c.getName()+" via c object");;
	}
}