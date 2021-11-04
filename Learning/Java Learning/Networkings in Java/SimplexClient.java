import java.io.*;  
import java.net.*;  
public class SimplexClient {  
	public static void main(String[] args) {  
		try{      
			Socket s=new Socket("localhost",6666);
			System.out.println("Connected to Server");
			DataInputStream din=new DataInputStream(s.getInputStream());  
			System.out.println("Waiting for Message from Server...");
			String s1 =(String)din.readUTF();  
			System.out.println("message= "+ s1);  
			s.close();  
		}catch(Exception ex){
			System.out.println(ex);
		}  
	}  
}  
