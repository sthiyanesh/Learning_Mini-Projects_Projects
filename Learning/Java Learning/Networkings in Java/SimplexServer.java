import java.lang.*;
import java.util.*;
import java.io.*;  
import java.net.*;  
public class SimplexServer {  
	public static void main(String[] args){  
		try{  
			ServerSocket ss=new ServerSocket(6666);
			System.out.println("Waiting for Client");
			Socket s=ss.accept();
			System.out.println("Connected to Client");
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Message for Client:");
			String s1 = sc.nextLine();
			dos.writeUTF(s1);  
			dos.flush();  
			dos.close();			
			ss.close();  
		}catch(Exception e){
			System.out.println(e);
		}			
	}  
}  