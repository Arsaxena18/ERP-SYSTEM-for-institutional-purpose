package erpsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener {
    
    Choice cemp;
    JTable tb;
    JButton sc, pr, up, add, can;
    
    TeacherDetails() {
        getContentPane().setBackground(Color.WHITE);  // Setting background color
        setLayout(null);  // Using absolute layout
        
        // Label for employee ID
        JLabel heading = new JLabel("Employee ID :");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        // Choice dropdown for employee IDs
        cemp = new Choice();
        cemp.setBounds(180, 20, 150, 20);
        add(cemp);
        
        // Fetching employee IDs from database and adding to choice dropdown
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Teacher");
            while (rs.next()) {
                cemp.add(rs.getString("rn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Initializing table to display teacher details
        tb = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Teacher");
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
            String query = "select * from Teacher where rn='" + cemp.getSelectedItem() + "'";
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
            new AddTeacher();
        } else if (ae.getSource() == up) {  // If update button is clicked
            setVisible(false);
            new UpdateTeacherdt();
        } else {  // If cancel button is clicked
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();  // Create and show the frame
    }
}
