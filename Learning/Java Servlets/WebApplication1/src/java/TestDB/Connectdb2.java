/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDB;

/**
 *
 * @author gowri
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gowrish
 */
public class Connectdb2 {
    public int checkpass(String uname, String upass){
        System.out.println("Received " + uname + " " + upass);
            String url = "jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:XE";
            Connection con = null;
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                con= DriverManager.getConnection(url);                
                if(con != null)
                    System.out.println("Connected");
                else
                    System.out.println("Error in connection");
                PreparedStatement s = con.prepareStatement("select * from TEST.login");
                ResultSet rs = s.executeQuery();
                System.out.println("Test " + rs.getFetchSize());
                int flag=0;
                while(rs.next()){                    
                    System.out.println("Comparing " + rs.getString(1) + "  " + uname);
                    if(rs.getString(1).toString().equals(uname.toString())){
                        System.out.println("username matched");
                        flag = 1;
                        if(rs.getString(2).toString().equals(upass.toString())){
                            System.out.println("Matched");
                            return 0;
                        }
                    }
                }
                if(flag == 1){
                System.out.println("Username and Password dont match");
                return 1;
                }else{
                System.out.println("Username not found");
                return 2;
                }
            }catch(Exception e){
                System.out.println("Exception " + e);
            }finally{
                try {
                    con.close();            
                }catch(Exception e) { System.out.println(e); }
            }    
            return 3;
        }
    public int register(String uname, String upass){
        System.out.println("Received " + uname + " " + upass);
            String url = "jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:XE";
            Connection con = null;
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                con= DriverManager.getConnection(url);                
                if(con != null)
                    System.out.println("Connected");
                else
                    System.out.println("Error in connection");
                PreparedStatement s = con.prepareStatement("select * from TEST.login");
                ResultSet rs = s.executeQuery();
                System.out.println("Test " + rs.getFetchSize());
                while(rs.next()){                    
                    System.out.println("Comparing " + rs.getString(1) + "  " + uname);
                    if(rs.getString(1).toString().equals(uname.toString())){
                        System.out.println("username matched");
                        return 1;
                    }
                }   
                s = con.prepareStatement("insert into TEST.login values(?,?)");
                s.setString(1, uname);
                s.setString(2, upass);
                s.executeUpdate();
                return 0;
            }catch(Exception e){
                System.out.println("Exception " + e);
            }finally{
                try {
                    con.close();            
                }catch(Exception e) { System.out.println(e); }
            }    
            return 2;
        }
    }
/*package TestDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Connectdb2 {
    public int checkpass(String uname, String upass){
            String url = "jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:XE";
            Connection con = null;
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                con= DriverManager.getConnection(url);                
                if(con != null)
                    System.out.println("Connected");
                else
                    System.out.println("Error in connection");
                PreparedStatement s = con.prepareStatement("select * from TEST.login");
                ResultSet rs = s.executeQuery();
                int flag=0;
                while(rs.next()){                    
                    if(rs.getString(1).toString().equals(uname.toString())){
                        flag = 1;
                        if(rs.getString(2).toString().equals(upass.toString())){
                            return 0;
                        }
                    }
                }
                if(flag == 1){
                System.out.println("Username and Password dont match");
                return 1;
                }else{
                System.out.println("Username not found");
                return 2;
                }
            }catch(Exception e){
                System.out.println("Exception " + e);
            }finally{
                try {
                    con.close();            
                }catch(Exception e) { System.out.println(e); }
            }    
            return 3;
        }
    public int register(String uname, String upass){
        String url = "jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:XE";
            Connection con = null;
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                con= DriverManager.getConnection(url);                
                if(con != null)
                    System.out.println("Connected");
                else
                    System.out.println("Error in connection");
                PreparedStatement s = con.prepareStatement("select * from TEST.login");
                ResultSet rs = s.executeQuery();
                while(rs.next()){                    
                    if(rs.getString(1).toString().equals(uname.toString())){
                        return 1;
                    }
                }   
                s = con.prepareStatement("insert into TEST.login values(?,?)");
                s.setString(1, uname);
                s.setString(2, upass);
                s.executeUpdate();
                return 0;
            }catch(Exception e){
                System.out.println("Exception " + e);
            }finally{
                try {
                    con.close();            
                }catch(Exception e) { System.out.println(e); }
            }    
            return 2;
        }
    }
*/
