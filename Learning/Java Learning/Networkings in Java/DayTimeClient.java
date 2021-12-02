import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DayTimeClient {

  public static void main(String[] args) {

    String hostname = "time.nist.gov";

    try {
      Socket theSocket = new Socket(hostname, 13);
      InputStream timeStream = theSocket.getInputStream();
      StringBuffer time = new StringBuffer();
      int c;
      while ((c = timeStream.read()) != -1){
        time.append((char) c);
      }
      String timeString = time.toString().trim();
      int i=0;
      for (i=0;i<timeString.length();i++){
          if(timeString.charAt(i)==' ')
            break;
      }
      String yr = timeString.substring(i+1,i+3);
      String mon = timeString.substring(i+4,i+6);
      String day = timeString.substring(i+7,i+9);
      String tim = timeString.substring(i+10,i+18);
      System.out.println("Date:"+day+"-"+mon+"-"+yr+"\nTime:"+tim+" UTC at "+hostname);
    } // end try
    catch (UnknownHostException ex) {
      System.err.println(ex);
    } catch (IOException ex) {
      System.err.println(ex);
    }

  }

}