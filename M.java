package erpsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class M extends JFrame implements ActionListener {
    
    String rn;
    JButton can;
    
    M(String rn) {
        this.rn = rn;  // Initializing roll number
        
        setSize(500, 600);  // Setting frame size
        setLocation(400, 50);  // Setting frame location
        setLayout(null);  // Using absolute layout
        
        getContentPane().setBackground(Color.WHITE);  // Setting background color
        
        JLabel heading = new JLabel("D Technical University");
        heading.setBounds(120, 10, 500, 25);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2024");
        subheading.setBounds(120, 50, 500, 20);
        subheading.setFont(new Font("Serif", Font.BOLD, 18));
        add(subheading);
        
        JLabel lblrollno = new JLabel("Roll Number " + rn);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblrollno);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblsemester);
        
        JLabel lsub1 = new JLabel();
        lsub1.setBounds(100, 200, 500, 20);
        lsub1.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lsub1);
        
        JLabel lsub2 = new JLabel();
        lsub2.setBounds(100, 230, 500, 20);
        lsub2.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lsub2);
        
        JLabel lsub3 = new JLabel();
        lsub3.setBounds(100, 260, 500, 20);
        lsub3.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lsub3);
        
        JLabel lsub4 = new JLabel();
        lsub4.setBounds(100, 290, 500, 20);
        lsub4.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lsub4);
        
        JLabel lsub5 = new JLabel();
        lsub5.setBounds(100, 320, 500, 20);
        lsub5.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lsub5);
        
        JLabel lsub6 = new JLabel();
        lsub6.setBounds(100, 350, 500, 20);
        lsub6.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lsub6);
        
        try {
            Conn c = new Conn();
            
            // Fetching subject details from 'sub' table based on roll number
            ResultSet rs1 = c.s.executeQuery("select * from sub where rn = '" + rn + "'");
            while (rs1.next()) {
                lsub1.setText(rs1.getString("sub1"));
                lsub2.setText(rs1.getString("sub2"));
                lsub3.setText(rs1.getString("sub3"));  
                lsub4.setText(rs1.getString("sub4"));
                lsub5.setText(rs1.getString("sub5"));
                lsub6.setText(rs1.getString("sub6"));
            }
            
            // Fetching marks details from 'marks' table based on roll number
            ResultSet rs2 = c.s.executeQuery("select * from marks where rn = '" + rn + "'");
            while (rs2.next()) {
                // Appending marks to existing subject labels
                lsub1.setText(lsub1.getText() + "------------" + rs2.getString("m1"));
                lsub2.setText(lsub2.getText() + "------------" + rs2.getString("m2"));
                lsub3.setText(lsub3.getText() + "------------" + rs2.getString("m3"));
                lsub4.setText(lsub4.getText() + "------------" + rs2.getString("m4"));
                lsub5.setText(lsub5.getText() + "------------" + rs2.getString("m5"));
                lsub6.setText(lsub6.getText() + "------------" + rs2.getString("m6"));
                lblsemester.setText("Semester " + rs2.getString("sem"));  // Setting semester label
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        can = new JButton("Back");
        can.setBounds(250, 500, 120, 25);
        can.setBackground(Color.BLACK);
        can.setForeground(Color.WHITE);
        can.addActionListener(this);
        can.setFont(new Font("Serif", Font.BOLD, 15));
        add(can);
        
        setVisible(true);  // Setting frame visibility
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);  // Hiding the frame when 'Back' button is clicked
    }
    
    public static void main(String[] args) {
        new M(" ");  // Creating instance of M frame (here ' ' is passed as placeholder roll number)
    }
}
