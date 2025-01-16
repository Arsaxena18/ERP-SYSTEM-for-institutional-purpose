package erpsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class TeacherLeavedt extends JFrame implements ActionListener {
    
    Choice cEmpId;
    JTable tb;
    JButton sc, pr, can;
    
    TeacherLeavedt() {
        
        getContentPane().setBackground(Color.WHITE);  // Setting background color
        setLayout(null);  // Using absolute layout
        
        JLabel heading = new JLabel("Employee ID :");  // Label for employee ID
        heading.setBounds(20, 20, 150, 20);  // Setting bounds (x, y, width, height)
        add(heading);  // Adding label to frame
        
        cEmpId = new Choice();  // Choice dropdown for employee ID selection
        cEmpId.setBounds(180, 20, 150, 20);  // Setting bounds for choice dropdown
        add(cEmpId);  // Adding choice dropdown to frame
        
        try {
            Conn c = new Conn();  // Creating database connection
            ResultSet rs = c.s.executeQuery("select * from Teacher");  // Querying database for teacher details
            while (rs.next()) {
                cEmpId.add(rs.getString("rn"));  // Adding employee IDs to choice dropdown
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        tb = new JTable();  // Creating table to display teacher leave details
        try {
            Conn c = new Conn();  // Creating database connection
            ResultSet rs = c.s.executeQuery("select * from teacherleav");  // Querying database for teacher leave details
            tb.setModel(DbUtils.resultSetToTableModel(rs));  // Setting table model with ResultSet using DbUtils
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(tb);  // Creating scrollable pane for table
        jsp.setBounds(0, 100, 900, 600);  // Setting bounds for scroll pane
        add(jsp);  // Adding scroll pane to frame
        
        sc = new JButton("Search");  // Search button
        sc.setBounds(20, 70, 80, 20);  // Setting bounds for search button
        sc.addActionListener(this);  // Adding ActionListener to search button
        add(sc);  // Adding search button to frame
        
        pr = new JButton("Print");  // Print button
        pr.setBounds(150, 70, 80, 20);  // Setting bounds for print button
        pr.addActionListener(this);  // Adding ActionListener to print button
        add(pr);  // Adding print button to frame
        
        can = new JButton("Cancel");  // Cancel button
        can.setBounds(300, 70, 80, 20);  // Setting bounds for cancel button
        can.addActionListener(this);  // Adding ActionListener to cancel button
        add(can);  // Adding cancel button to frame
        
        setSize(900, 600);  // Setting frame size
        setLocation(200, 50);  // Setting frame location
        setVisible(true);  // Setting frame visibility
    }
    
    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sc) {  // If search button is clicked
            String query = "select * from teacherleav where EmpId='" + cEmpId.getSelectedItem() + "'";  // SQL query to fetch specific teacher's leave details
            try {
                Conn c = new Conn();  // Creating database connection
                ResultSet rs = c.s.executeQuery(query);  // Executing query
                tb.setModel(DbUtils.resultSetToTableModel(rs));  // Setting table model with ResultSet using DbUtils
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pr) {  // If print button is clicked
            try {
                tb.print();  // Print the table
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {  // If cancel button is clicked
            setVisible(false);  // Hide the frame
        }
    }
    
    // Main method to instantiate and display the TeacherLeavedt frame
    public static void main(String[] args) {
        new TeacherLeavedt();
    }
}
