import java.net.*;
import java.io.*;
import java.util.*;
public class DNSserver{
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Menu:\n1.DNS\t2.Exit\n");
            System.out.print("Enter your choice:");
            n = sc.nextInt(); 
            if(n==1){
                try{
                    System.out.print("\nEnter Host Name:");
                    sc.nextLine();
                    String hname=sc.nextLine();
                    InetAddress address = InetAddress.getByName(hname);
                    System.out.println("\nHost Name: " + address.getHostName());
                    System.out.println("IP Address: " + address.getHostAddress()+"\n");
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }while(n!=2);
    }
}