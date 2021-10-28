import java.lang.*;
import java.util.*;
import java.io.*;  
import java.net.*;  
public class Server {  
	public static void main(String[] args){  
		try{  
			ServerSocket ss=new ServerSocket(6666);
			System.out.println("Waiting for Client");
			Socket s=ss.accept();
			System.out.println("Connected to Client");
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			Scanner sc = new Scanner(System.in);
			String s1;
			while(true){
				System.out.print("Enter Message for Client:");
				s1 = sc.nextLine();
				dos.writeUTF(s1);  
				dos.flush();
				if(s1.equals("End")){
					System.out.println("You Reset the Connection");
					break;
				}
				System.out.println("Waiting for Message from Client...");
				s1 =(String)dis.readUTF();  
				System.out.println("message= "+ s1);
				if(s1.equals("End")){
					System.out.println("Client Reset the Connecetion");
					break;
				}
			}
			dos.close();			
			ss.close();  
		}catch(Exception e){
			System.out.println(e);
		}			
	}  
}  