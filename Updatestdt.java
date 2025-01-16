package erpsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.*;

public class Updatestdt extends JFrame implements ActionListener{
    
    JTextField tfname, tffname, tfadd, tfph, tfem, tfX, tfXII, tfad, tfcb, tfcbb;
    JLabel rn;
    JButton sub, can;
    Choice crn;
    
    Updatestdt() {
        setSize(1920, 1080);  // Setting frame size
        setLayout(null);  // Using absolute layout
        
        JLabel heading = new JLabel("Update Student Details");  // Heading label
        heading.setBounds(470, 30, 500, 50);  // Setting bounds for heading
        heading.setFont(new Font("serif", Font.BOLD, 30));  // Setting font for heading
        add(heading);  // Adding heading to frame
        
        JLabel lbrn = new JLabel(" Select Roll Number :");  // Label for selecting roll number
        lbrn.setBounds(60, 20, 150, 20);  // Setting bounds for roll number label
        lbrn.setFont(new Font("serif", Font.BOLD, 15));  // Setting font for roll number label
        add(lbrn);  // Adding roll number label to frame
        
        crn = new Choice();  // Choice dropdown for roll number selection
        crn.setBounds(220, 20, 150, 20);  // Setting bounds for choice dropdown
        add(crn);  // Adding choice dropdown to frame
        
        try {
            Conn c = new Conn();  // Creating database connection
            ResultSet rs = c.s.executeQuery("select * from stdus");  // Querying database for student details
            while (rs.next()) {
                crn.add(rs.getString("rn"));  // Adding roll numbers to choice dropdown
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name :");  // Label for student name
        lblname.setBounds(70, 100, 100, 30);  // Setting bounds for name label
        lblname.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for name label
        add(lblname);  // Adding name label to frame
        
        JLabel name = new JLabel();  // Label to display student name
        name.setBounds(200, 100, 150, 30);  // Setting bounds for name display label
        name.setFont(new Font("serif", Font.PLAIN, 20));  // Setting font for name display label
        add(name);  // Adding name display label to frame
        
        JLabel lblfname = new JLabel("Father's Name :");  // Label for father's name
        lblfname.setBounds(400, 100, 170, 30);  // Setting bounds for father's name label
        lblfname.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for father's name label
        add(lblfname);  // Adding father's name label to frame
        
        JLabel fname = new JLabel();  // Label to display father's name
        fname.setBounds(600, 100, 150, 30);  // Setting bounds for father's name display label
        fname.setFont(new Font("serif", Font.PLAIN, 20));  // Setting font for father's name display label
        add(fname);  // Adding father's name display label to frame
        
        JLabel lblrn = new JLabel("Roll Number :");  // Label for roll number
        lblrn.setBounds(50, 200, 170, 30);  // Setting bounds for roll number label
        lblrn.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for roll number label
        add(lblrn);  // Adding roll number label to frame
        
        rn = new JLabel();  // Label to display roll number
        rn.setBounds(200, 200, 170, 30);  // Setting bounds for roll number display label
        rn.setFont(new Font("serif", Font.PLAIN, 20));  // Setting font for roll number display label
        add(rn);  // Adding roll number display label to frame
        
        JLabel lbldob = new JLabel("Date Of Birth :");  // Label for date of birth
        lbldob.setBounds(400, 200, 170, 30);  // Setting bounds for date of birth label
        lbldob.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for date of birth label
        add(lbldob);  // Adding date of birth label to frame
        
        JLabel d = new JLabel();  // Label to display date of birth
        d.setBounds(600, 200, 150, 30);  // Setting bounds for date of birth display label
        d.setFont(new Font("serif", Font.PLAIN, 20));  // Setting font for date of birth display label
        add(d);  // Adding date of birth display label to frame
        
        JLabel lbladd = new JLabel("Address :");  // Label for address
        lbladd.setBounds(60, 300, 100, 30);  // Setting bounds for address label
        lbladd.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for address label
        add(lbladd);  // Adding address label to frame
        
        tfadd = new JTextField();  // Text field for address
        tfadd.setBounds(200, 300, 150, 30);  // Setting bounds for address text field
        add(tfadd);  // Adding address text field to frame
        
        JLabel lblph = new JLabel("Phone Number :");  // Label for phone number
        lblph.setBounds(400, 300, 170, 30);  // Setting bounds for phone number label
        lblph.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for phone number label
        add(lblph);  // Adding phone number label to frame
        
        tfph = new JTextField();  // Text field for phone number
        tfph.setBounds(600, 300, 150, 30);  // Setting bounds for phone number text field
        add(tfph);  // Adding phone number text field to frame
        
        JLabel lblem = new JLabel("Email Id :");  // Label for email ID
        lblem.setBounds(60, 400, 100, 30);  // Setting bounds for email ID label
        lblem.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for email ID label
        add(lblem);  // Adding email ID label to frame
        
        tfem = new JTextField();  // Text field for email ID
        tfem.setBounds(200, 400, 150, 30);  // Setting bounds for email ID text field
        add(tfem);  // Adding email ID text field to frame
        
        JLabel lblX = new JLabel("Class X(%) :");  // Label for Class X percentage
        lblX.setBounds(400, 400, 170, 30);  // Setting bounds for Class X label
        lblX.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for Class X label
        add(lblX);  // Adding Class X label to frame
        
        JLabel X = new JLabel();  // Label to display Class X percentage
        X.setBounds(600, 400, 150, 30);  // Setting bounds for Class X display label
        X.setFont(new Font("serif", Font.PLAIN, 20));  // Setting font for Class X display label
        add(X);  // Adding Class X display label to frame
        
        JLabel lblXII = new JLabel("Class XII(%) :");  // Label for Class XII percentage
        lblXII.setBounds(50, 500, 200, 30);  // Setting bounds for Class XII label
        lblXII.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for Class XII label
        add(lblXII);  // Adding Class XII label to frame
        
        JLabel XII = new JLabel();  // Label to display Class XII percentage
        XII.setBounds(200, 500, 150, 30);  // Setting bounds for Class XII display label
        XII.setFont(new Font("serif", Font.PLAIN, 20));  // Setting font for Class XII display label
        add(XII);  // Adding Class XII display label to frame
        
        JLabel lblad = new JLabel("Adhaar Number :");  // Label for Aadhar number
        lblad.setBounds(400, 500, 170, 30);  // Setting bounds for Aadhar number label
        lblad.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for Aadhar number label
        add(lblad);  // Adding Aadhar number label to frame
        
        JLabel ad = new JLabel();  // Label to display Aadhar number
        ad.setBounds(600, 500, 150, 30);  // Setting bounds for Aadhar number display label
        ad.setFont(new Font("serif", Font.PLAIN, 20));  // Setting font for Aadhar number display label
        add(ad);  // Adding Aadhar number display label to frame
        
        JLabel lblc = new JLabel("Course :");  // Label for course
        lblc.setBounds(830, 100, 170, 30);  // Setting bounds for course label
        lblc.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for course label
        add(lblc);  // Adding course label to frame
        
        tfcb = new JTextField();  // Text field for course
        tfcb.setBounds(930, 100, 170, 30);  // Setting bounds for course text field
        tfcb.setBackground(Color.WHITE);  // Setting background color for course text field
        add(tfcb);  // Adding course text field to frame
        
        JLabel lblbr = new JLabel("Branch :");  // Label for branch
        lblbr.setBounds(830, 200, 170, 30);  // Setting bounds for branch label
        lblbr.setFont(new Font("serif", Font.BOLD, 20));  // Setting font for branch label
        add(lblbr);  // Adding branch label to frame
        
        tfcbb = new JTextField();  // Text field for branch
        tfcbb.setBounds(930, 200, 170, 30);  // Setting bounds for branch text field
        tfcbb.setBackground(Color.WHITE);  // Setting background color for branch text field
        add(tfcbb);  // Adding branch text field to frame
        
        try {
            Conn c = new Conn();  // Creating database connection
            String query = "select * from stdus where rn='" + crn.getSelectedItem() + "'";  // SQL query to fetch student details based on selected roll number
            ResultSet rs = c.s.executeQuery(query);  // Executing query
            if (rs.next()) {
                // Setting values retrieved from database to respective fields
                name.setText(rs.getString("name"));
                fname.setText(rs.getString("fname"));
                d.setText(rs.getString("dob"));
                X.setText(rs.getString("class_X"));
                XII.setText(rs.getString("class_XII"));
                tfadd.setText(rs.getString("adr"));
                ad.setText(rs.getString("ad"));
                tfcb.setText(rs.getString("c"));
                tfcbb.setText(rs.getString("br"));
                tfph.setText(rs.getString("ph"));
                tfem.setText(rs.getString("em"));
                rn.setText(rs.getString("rn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();  // Creating database connection
                    String query = "select * from stdus where rn='" + crn.getSelectedItem() + "'";  // SQL query to fetch student details based on selected roll number
                    ResultSet rs = c.s.executeQuery(query);  // Executing query
                    if (rs.next()) {
                        // Setting values retrieved from database to respective fields
                        name.setText(rs.getString("name"));
                        fname.setText(rs.getString("fname"));
                        d.setText(rs.getString("dob"));
                        X.setText(rs.getString("class_X"));
                        XII.setText(rs.getString("class_XII"));
                        tfadd.setText(rs.getString("adr"));
                        ad.setText(rs.getString("ad"));
                        tfcb.setText(rs.getString("c"));
                        tfcbb.setText(rs.getString("br"));
                        tfph.setText(rs.getString("ph"));
                        tfem.setText(rs.getString("em"));
                        rn.setText(rs.getString("rn"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        sub = new JButton("UPDATE");  // Update button
        sub.setBounds(830, 300, 120, 30);  // Setting bounds for update button
        sub.setBackground(Color.BLACK);  // Setting background color for update button
        sub.setForeground(Color.WHITE);  // Setting foreground color for update button
        sub.addActionListener(this);  // Adding ActionListener to update button
        sub.setFont(new Font("serif", Font.BOLD, 15));  // Setting font for update button
        add(sub);  // Adding update button to frame
        
        can = new JButton("CANCEL");  // Cancel button
        can.setBounds(1030, 300, 120, 30);  // Setting bounds for cancel button
        can.setBackground(Color.BLACK);  // Setting background color for cancel button
        can.setForeground(Color.WHITE);  // Setting foreground color for cancel button
        can.addActionListener(this);  // Adding ActionListener to cancel button
        can.setFont(new Font("serif", Font.BOLD, 15));  // Setting font for cancel button
        add(can);  // Adding cancel button to frame
        
        setVisible(true);  // Setting frame visibility
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sub) {  // If update button is clicked
            String roll = rn.getText();  // Getting roll number
            String add = tfadd.getText();  // Getting address
            String ph = tfph.getText();  // Getting phone number
            String email = tfem.getText();  // Getting email ID
            String course = tfcb.getText();  // Getting course
            String branch = tfcbb.getText();  // Getting branch
            
            try {
                String query = "update stdus set adr='" + add + "',ph='" + ph + "',em='" + email + "',c='" + course + "',br='" + branch + "' where rn='" + roll + "'";  // SQL query to update student details
                Conn con = new Conn();  // Creating database connection
                con.s.executeUpdate(query);  // Executing update query
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");  // Displaying success message
                setVisible(false);  // Hiding frame
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {  // If cancel button is clicked
            setVisible(false);  // Hiding frame
        }
    }
    
    public static void main(String[] args) {
        new Updatestdt();  // Creating instance of Updatestdt frame
    }
}
