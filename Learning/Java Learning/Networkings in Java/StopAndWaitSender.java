import java.net.*;
import java.io.*;
import java.util.*;
public class StopAndWaitSender{
    public static void main(String Args[]){
        try{
            Socket s = new Socket("localhost",6666);
            System.out.println("Connected to Receiver...");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Enter the No.of.Frames:");
            Scanner sc = new Scanner(System.in);
            int len = sc.nextInt();
            sc.nextLine();
            dout.writeUTF(Integer.toString(len));
            String msg;
            for(int i=0;i<len;i++){
                System.out.println("Enter Data for "+(i+1)+"th Frame:");
                msg = sc.nextLine();
                dout.writeUTF(msg);
                System.out.println("Frame Sent.");
                int ack = Integer.parseInt(din.readUTF());
                System.out.println("The Acknowledgemnt received for "+(ack)+"th frame");
            }
        }catch(Exception e){
            System.out.println("Error occured:"+e);
        }
    }
}