import java.lang.*;
import java.util.*;
import java.net.*;
import java.io.*;
class msg{
	public static void main(String args[]){
		try{
			int x;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the Connection Number:");
			x = sc.nextInt();
			ServerSocket ss = new ServerSocket(x);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Client");
			String str = (String)din.readUTF();
			System.out.println(str);
		}catch(Exception e){
			System.out.print(e);
		}
	}
}