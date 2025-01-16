package erpsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener {
    
    // Declaring instance variables for choice, table, and buttons
    Choice crollno;
    JTable tb;
    JButton sc, pr, up, add, can;
    
    // Constructor to initialize the frame and its components
    StudentDetails() {
        getContentPane().setBackground(Color.WHITE);  // Setting background color
        setLayout(null);  // Using absolute layout
        
        // Label for roll number
        JLabel heading = new JLabel("Roll Number :");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        // Choice dropdown for roll numbers
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        // Fetching roll numbers from database and adding to choice dropdown
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from stdus");
            while (rs.next()) {
                crollno.add(rs.getString("rn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Initializing table to display student details
        tb = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from stdus");
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Scroll pane for table
        JScrollPane jsp = new JScrollPane(tb);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        // Search button
        sc = new JButton("Search");
        sc.setBounds(20, 70, 80, 20);
        sc.addActionListener(this);
        add(sc);
        
        // Print button
        pr = new JButton("Print");
        pr.setBounds(150, 70, 80, 20);
        pr.addActionListener(this);
        add(pr);
        
        // Update button
        up = new JButton("Update");
        up.setBounds(300, 70, 80, 20);
        up.addActionListener(this);
        add(up);
        
        // Add button
        add = new JButton("Add");
        add.setBounds(450, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        // Cancel button
        can = new JButton("Cancel");
        can.setBounds(600, 70, 80, 20);
        can.addActionListener(this);
        add(can);
        
        // Setting frame size, location, and visibility
        setSize(900, 600);
        setLocation(200, 50);
        setVisible(true);
    }
    
    // Handle button actions
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sc) {  // If search button is clicked
            String query = "select * from stdus where rn='" + crollno.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                tb.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pr) {  // If print button is clicked
            try {
                tb.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {  // If add button is clicked
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource() == up) {  // If update button is clicked
            setVisible(false);
            new Updatestdt();
        } else {  // If cancel button is clicked
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();  // Create and show the frame
    }
}
