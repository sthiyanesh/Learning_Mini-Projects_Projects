import java.sql.*;

public class jdbcex {
   static final String DB_URL = "jdbc:mysql://localhost/model1";
   static final String USER = "root";
   static final String PASS = "Sthiy@11062002";
   static final String QUERY = "SELECT * FROM employee";

   public static void main(String[] args)throws ClassNotFoundException  {
      // Open a connection
      try{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
         // Extract data from result set
			while (rs.next()) {
            // Retrieve by column name
				System.out.print("ID: " + rs.getInt("ssn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}