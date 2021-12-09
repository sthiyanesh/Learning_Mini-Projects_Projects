import java.util.*;
import java.io.*;
import java.net.*;
public class DateTimeClient{
    public static void main(String args[]) {
        try{
            Socket s = new Socket("localhost",6666);
            DataInputStream din = new DataInputStream(s.getInputStream());
            String date = din.readUTF();
            System.out.println("Date and Time from Server:\n"+date);
        }catch(Exception e){
            System.out.println("Error occurred:"+e);
        }
    }
}