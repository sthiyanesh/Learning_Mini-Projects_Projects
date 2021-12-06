import java.io.*;  
import java.net.*;  
public class t {  
public static void main(String[] args) {
for(int i=0;i<3;i++){	
try{      
Socket s=new Socket("localhost",6666);  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
dout.writeUTF("Hello Server");  
System.out.println("written");
dout.flush();  
dout.close();  
s.close(); 
Thread.sleep(1000); 
}catch(Exception e){System.out.println(e);}  
}  }
}  