package erpsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    // Constructor to initialize the database connection
    Conn() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection to the database
            // Replace "erpsystem", "root", and "root" with your database name, username, and password respectively
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpsystem", "root", "root");
            
            // Create a statement object to execute SQL queries
            s = c.createStatement();
        } catch (Exception e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
    }
}
