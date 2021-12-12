import java.io.*;
import java.util.*;
import java.net.*;
class WebServer{
    public static void main(String args[]){
        try{  
			ServerSocket ss=new ServerSocket(6666);
			System.out.println("Waiting for Client");
			Socket s=ss.accept();
			System.out.println("Connected to Client");
            DataInputStream din=new DataInputStream(s.getInputStream());  
			System.out.println("Waiting for URL from Client...");
            String s1 =(String)din.readUTF();
            URL url = new URL(s1);
            Scanner sc = new Scanner(url.openStream());
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext())
                sb.append(sc.next());
            String result = sb.toString();
            result = result.replaceAll(">", ">\n");
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(result);  
			dos.flush();
			dos.close();
			ss.close();
        }catch(Exception e){
			System.out.println(e);
		}	
    }
}