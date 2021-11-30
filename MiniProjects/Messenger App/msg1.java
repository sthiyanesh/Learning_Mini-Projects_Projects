import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;
public class msg1 extends Thread{
	public void run(){
		try{
			int x;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Your Connection Number:");
			x = sc.nextInt();
			ServerSocket ss1 = new ServerSocket(x);
			Socket s1 = ss1.accept();
			DataInputStream din = new DataInputStream(s1.getInputStream());
			String str = (String)din.readUTF();
		}catch(Exception e){
			System.out.println(e);
		}
	}		
	public static void main(String args[]){
		msg1 m1 = new msg1();
		m1.start();
		try{
			int x;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the Connection Number:");
			x = sc.nextInt();
			Socket s = new Socket("localhost",x);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Server");
			dout.flush();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}