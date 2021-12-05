import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
class proc{
public static ServerSocket ss;  
public static Socket s;  
public static Socket s1;
public static DataOutputStream dos;
public static DataInputStream din;
public static String  str = "", str1 = "" , str2 = "" , str3 = "";
public static int z = 0;
public static void main(String[] args){
JFrame ms = new JFrame("MESSENGER client");
JPanel p2 = new JPanel();
JTextField tf = new JTextField("");
JButton b1 = new JButton("SEND");
JTextArea ta = new JTextArea();
JScrollPane sp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
sp.setBounds(5,25,621,550);
ta.setEditable(false);
b1.setBounds(521,575,100,25);
tf.setEditable(true);
tf.setBounds(5,575,521,25);
p2.setBounds(5,0,621,25);
p2.setBackground(Color.red);
ms.setSize(650,650);
ms.setVisible(true);
ms.setLayout(null);
ms.add(p2);
ms.add(tf);
ms.add(b1);
ms.add(sp);
b1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e){
try{
str1 = tf.getText();
dos.writeUTF(str1);
dos.flush();
str3 = ta.getText();
str3 += "\nYou = "+str1;
ta.setText(str3);
tf.setText("");
}
catch(Exception ex){System.out.println(ex);}  
}
} );
try{
s1 =new Socket("localhost",6666);
}
catch(Exception ex){
try{
ss = new ServerSocket(8888);
s = ss.accept();
z = 1;
}
catch(Exception E){
System.out.println(E);
}
}
try{
if (z == 1){
din=new DataInputStream(s.getInputStream());  
dos=new DataOutputStream(s.getOutputStream());
}
else {
din=new DataInputStream(s1.getInputStream());  
dos=new DataOutputStream(s1.getOutputStream());
}
            while (!str.equals("stop")){
str =(String)din.readUTF();
str3 = ta.getText();
str3 += "\nServer = "+str;
ta.setText(str3);
            }
  System.out.print("\n");
  din.close();
  dos.close();
  s.close();
        }
  catch(Exception e){
  System.out.println(e);
}  
    }
}
