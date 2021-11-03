import java.lang.*;
import java.util.*;
import java.io.*;  
import java.net.*;  
public class HalfDuplexClient {  
	public static void main(String[] args) {  
		try{      
			Socket s=new Socket("localhost",6666);
			System.out.println("Connected to Server");
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			Scanner sc = new Scanner(System.in);
			String s1;
			while(true){
				System.out.println("Waiting for Message from Server...");
				s1 =(String)din.readUTF();  
				System.out.println("message= "+ s1);
				if(s1.equals("End")){
					System.out.println("Server Reset the Connecetion");
					break;
				}
				System.out.print("Enter Message for Server:");
				s1 = sc.nextLine();
				dout.writeUTF(s1);  
				dout.flush();
				if(s1.equals("End")){
					System.out.println("You Reset the Connection");
					break;
				}
			}
			s.close();  
		}catch(Exception ex){
			System.out.println(ex);
		}  
	}  
}  
