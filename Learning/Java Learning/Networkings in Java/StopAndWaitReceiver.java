import java.net.*;
import java.io.*;
public class StopAndWaitReceiver{
    public static void main(String Args[]){
        try{
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Waiting for Sender...");
            Socket s = ss.accept();
            System.out.println("Connected to Sender...");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            int len = Integer.parseInt(din.readUTF());
            String msg;
            for(int i=0;i<len;i++){
                msg = (String) din.readUTF();
                System.out.println("The Data Received from Sender in "+(i+1)+"th frame is:"+msg);
                dout.writeUTF(Integer.toString(i+2));
                System.out.println("Acknowledgement sent.");
            }
        }catch(Exception e){
            System.out.println("Error occured:"+e);
        }
    }
}