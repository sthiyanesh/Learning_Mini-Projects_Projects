/*
<applet code="Banner" width=300 height=50>
</applet>
*/

import java.lang.*;
import java.awt.Color;
import java.awt.*;
import java.applet.*;
public class Banner extends Applet implements Runnable {
    String msg = " A Simple Moving Banner.";
    Thread t = null;
    int state;
    volatile boolean stopFlag;
// Set colors and initialize thread.
    public void init() {
        setBackground(Color.cyan);
        setForeground(Color.red);
    }
// Start thread
    public void start() {
        t = new Thread(this);
        stopFlag = false;
        t.start();
    }
// Entry point for the thread that runs the banner.
    public void run() {
// Redisplay banner
        for( ; ; ) {
            try {
                repaint();
                Thread.sleep(250);
                if(stopFlag)
                    break;
            } catch(InterruptedException e) {}
        }
    }
// Pause the banner.
    public void stop() {
        stopFlag = true;
        t = null;
    }
// Display the banner.
    public void paint(Graphics g) {
        char ch;
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        g.drawString(msg, 50, 30);
    }
}