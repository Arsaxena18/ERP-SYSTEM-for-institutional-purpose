package erpsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {
    
    Choice cEmpId;
    Choice ctime;
    JButton sub, can;
    JDateChooser dcdate;
    
    TeacherLeave() {
        setSize(500, 550);  // Setting frame size
        setLocation(350, 75);  // Setting frame location
        setLayout(null);  // Using absolute layout
        
        getContentPane().setBackground(Color.WHITE);  // Setting background color
        
        // Heading label for the leave application form for teachers
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);
        
        // Label and choice dropdown for employee ID
        JLabel EmpId = new JLabel("Employee ID :");
        EmpId.setBounds(40, 100, 150, 20);
        EmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(EmpId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(60, 130, 200, 20);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Teacher");
            while (rs.next()) {
                cEmpId.add(rs.getString("rn"));  // Adding employee IDs from the database to the choice dropdown
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Label and JDateChooser for selecting date
        JLabel lbldate = new JLabel("Date :");
        lbldate.setBounds(40, 160, 150, 20);
        lbldate.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 190, 200, 30);
        add(dcdate);
        
        // Label and choice dropdown for selecting duration (full day / half day)
        JLabel lblt = new JLabel("Duration :");
        lblt.setBounds(40, 230, 150, 20);
        lblt.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblt);
        
        ctime = new Choice();
        ctime.setBounds(60, 260, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        // Submit button
        sub = new JButton("SUBMIT");
        sub.setBounds(60, 300, 100, 20);
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this);
        sub.setFont(new Font("serif", Font.BOLD, 15));
        add(sub);
        
        // Cancel button
        can = new JButton("CANCEL");
        can.setBounds(60, 330, 100, 20);
        can.setBackground(Color.BLACK);
        can.setForeground(Color.WHITE);
        can.addActionListener(this);
        can.setFont(new Font("serif", Font.BOLD, 15));
        add(can);
        
        setVisible(true);  // Set frame visibility
    }
    
    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sub) {  // If submit button is clicked
            String EmpId = cEmpId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();  // Get selected date from JDateChooser
            String duration = ctime.getSelectedItem();  // Get selected duration
            
            // SQL query to insert leave application details into database
            String query = "insert into teacherleav values('" + EmpId + "','" + date + "','" + duration + "')";
            try {
                Conn con = new Conn();
                con.s.executeUpdate(query);  // Execute SQL update query
                JOptionPane.showMessageDialog(null, "Leave Confirmed");  // Show confirmation message
                setVisible(false);  // Hide the leave application form
            } catch (Exception e) {
                e.printStackTrace();
            }  
        } else {  // If cancel button is clicked
            setVisible(false);  // Hide the leave application form
        }
    }
    
    // Main method to instantiate and display the TeacherLeave frame
    public static void main(String[] args) {
        new TeacherLeave();
    }
}