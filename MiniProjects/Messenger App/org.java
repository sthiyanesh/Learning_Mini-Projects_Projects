import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class org{
	public static void main(String arg[]){
		JFrame ms = new JFrame("MESSENGER server");
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
	}
}