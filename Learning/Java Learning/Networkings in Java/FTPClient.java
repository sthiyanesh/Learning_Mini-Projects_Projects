import java.io.*;
import java.net.*;
import java.util.*;
public class FTPClient {
    public static void main(String[] args) throws Exception{
        int n;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Menu:\n1.Send File\t2.Exit\n");
            System.out.print("Enter your choice:");
            n = sc.nextInt();
            Socket socket; 
            if(n==1){
                socket = new Socket(InetAddress.getByName("localhost"), 5000);
                InetAddress IA = InetAddress.getByName("localhost");
                System.out.print("Enter FileName:");
                sc.nextLine();
                String str = sc.nextLine();
                File file = new File(str);
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream os = socket.getOutputStream();
                byte[] contents;
                long fileLength = file.length();
                long current = 0;
                long start = System.nanoTime();
                while(current!=fileLength){
                    int size = 10000;
                    if(fileLength - current >= size)
                        current += size;
                    else{
                        size = (int)(fileLength - current);
                        current = fileLength;
                    }
                    contents = new byte[size];
                    bis.read(contents, 0, size);
                    os.write(contents);
                }
                os.flush();
                socket.close();
                System.out.println("File sent succesfully!");
            }
        }while(n==1);
    }
}
