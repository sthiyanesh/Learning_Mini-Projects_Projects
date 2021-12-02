import java.net.*;
import java.io.*;
import java.util.*;
public class EchoClient{
    public static void main(String Args[]){
        try{
            Socket s = new Socket("localhost",6666);
            System.out.println("Server Connected");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.print("Enter Message for Server:");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            dout.writeUTF(msg);
            while(!msg.equals("End")){
                msg = (String) din.readUTF();
                System.out.println("The Message from EchoServer:"+msg);
                System.out.print("Enter Message for Server:");
                msg = sc.nextLine();
                dout.writeUTF(msg);
            }
        }catch(Exception e){
            System.out.println("The Error occurred:"+e);
        }
    }
}