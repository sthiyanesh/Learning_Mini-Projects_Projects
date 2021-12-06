import java.io.*;  
import java.net.*;  
public class threadtry {  
public static void main(String[] args){  
for(int i=0;i<3;i++){
try{  
ServerSocket ss=new ServerSocket(6666);  
Socket s=ss.accept();//establishes connection   
System.out.println("connected");
DataInputStream dis=new DataInputStream(s.getInputStream());  
String  str=(String)dis.readUTF();  
System.out.println("read");
System.out.println("message= "+str);  
ss.close();  
}catch(Exception e){System.out.println(e);}  
}}  
}  