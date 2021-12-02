import java.net.*;
import java.io.*;
public class EchoServer{
    public static void main(String Args[]){
        try{
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Waiting for Client...");
            Socket s = ss.accept();
            System.out.println("Client Connected");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String msg = (String) din.readUTF();
            System.out.println("The Message from Client:"+msg);
            while(!msg.equals("End")){
                dout.writeUTF(msg);
                msg = (String) din.readUTF();
                System.out.println("The Message from Client:"+msg);
            }
        }catch(Exception e){
            System.out.println("The Error occurred:"+e);
        }
    }
}