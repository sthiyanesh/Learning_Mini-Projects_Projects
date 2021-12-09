import java.net.*;
import java.io.*;
import java.util.*;
public class DateTimeServer{
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(new Date().toString());
            s.close();
        }catch(Exception e){
            System.out.println("Error occurred:"+e);
        }
    }
}