/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connectdb.Item;

/**
 *
 * @author THIYANESH S
 */
public class connectdb2 {
    public Item[] checkpass(String dbname){
        System.out.println("Received " + dbname);
            String url = "jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:XE";
            Connection con = null;
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                con= DriverManager.getConnection(url);                
                if(con != null)
                    System.out.println("Connected");
                else
                    System.out.println("Error in connection");
                String str = "select * from TEST."+dbname;
                PreparedStatement s = con.prepareStatement("select count(*) from TEST."+dbname);
                ResultSet rs = s.executeQuery();
                rs.next();
                System.out.println(rs.getInt(1));
                Item[] item = new Item[rs.getInt(1)];
                s = con.prepareStatement(str);
                rs = s.executeQuery();
                int i=0;
                while(rs.next()){                   
                    item[i] = new Item();
                    item[i].lap_img = rs.getString("LAP_IMG");
                    item[i].lap_name= rs.getString("LAP_NAME");
                    item[i].des1 = rs.getString("DES1");
                    item[i].des2 = rs.getString("DES2");
                    item[i].des3 = rs.getString("DES3");
                    item[i].des4 = rs.getString("DES4");
                    item[i].price = rs.getString("PRICE");
                    i++;
                }
                return item;
            }catch(Exception e){
                System.out.println("Exception " + e);
            }finally{
                try {
                    con.close();            
                }catch(Exception e) { System.out.println(e); }
            }    
            return null;
        }
}
