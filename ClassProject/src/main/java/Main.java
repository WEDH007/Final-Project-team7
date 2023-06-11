package main.java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/bookstore"; 
        String username = "root";
        String password = "password"; 

        Connection conn = null;

        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create the database connection
            conn = DriverManager.getConnection(url, username, password);

            // Connection successful
            System.out.println("Connected to the database!");
            
            Statement statement = conn.createStatement();

            // Perform database operations here...
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            
            while(resultSet.next()) {
            	System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)+ " " + resultSet.getString(3));
            }

        conn.close();
        }
        catch (Exception e) {
        	System.out.println(e);
        }
        
	}
}
