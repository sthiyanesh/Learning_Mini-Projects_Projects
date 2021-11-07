import java.io.*;
import java.util.*;
import java.net.*;
class WebClient{
    public static void main(String args[]){
        try{
            Socket s=new Socket("localhost",6666);
			System.out.println("Connected to Server");
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter URL:");
			String s1 = sc.nextLine();
			dos.writeUTF(s1);
            DataInputStream din=new DataInputStream(s.getInputStream());  
			System.out.println("Waiting for HTML Source Code from Server...");
			s1 =(String)din.readUTF();  
			System.out.println("WebPage Content=\n"+ s1);
            dos.flush();  
			dos.close();  
		}catch(Exception e){
			System.out.println(e);
		}			
	}  
}  