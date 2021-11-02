import java.io.*;
import java.net.*;
public class FTPServer{
    public static void main(String[] args) throws Exception{
        ServerSocket ssock = new ServerSocket(5000);
        Socket socket;
        do{
            socket = ssock.accept();
            byte[] contents = new byte[10000];
            File file = new File("receive.txt");
            int s  =(int)file.length();
            FileOutputStream fos = new FileOutputStream("receive.txt",true);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            InputStream is = socket.getInputStream();
            int bytesRead = 0;
            while((bytesRead=is.read(contents))!=-1)
                bos.write(contents, 0, bytesRead);
            bos.flush();
            System.out.println("File saved successfully!");
            socket.close();
        }while(socket.isConnected());
        ssock.close();
 } }