package erpsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeS extends JFrame {
    
    FeeS() {
        setSize(1000, 600);  // Setting frame size
        setLocation(150, 40);  // Setting frame location
        setLayout(null);  // Using absolute layout
        
        getContentPane().setBackground(Color.WHITE);  // Setting background color
        
        JLabel heading = new JLabel("Fee Structure");  // Creating heading label
        heading.setBounds(50, 10, 400, 30);  // Setting bounds for heading label
        heading.setFont(new Font("Serif", Font.BOLD, 30));  // Setting font for heading label
        add(heading);  // Adding heading label to the frame
        
        JTable table = new JTable();  // Creating a table to display fee structure
        
        try {
            Conn c = new Conn();  // Creating connection object to database
            ResultSet rs = c.s.executeQuery("select * from fees");  // Executing query to fetch data from 'fees' table
            table.setModel(DbUtils.resultSetToTableModel(rs));  // Setting table model using DbUtils to display result set data
        } catch (Exception e) {
            e.printStackTrace();  // Printing stack trace in case of any exception
        }
        
        JScrollPane jsp = new JScrollPane(table);  // Creating scroll pane to add table with scroll bars
        jsp.setBounds(0, 60, 1000, 700);  // Setting bounds for scroll pane
        add(jsp);  // Adding scroll pane to the frame
        
        setVisible(true);  // Setting frame visibility
        
    }
    
    public static void main(String[] args) {
        new FeeS();  // Creating instance of FeeS frame
    }
}
