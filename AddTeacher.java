package erpsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {
    // Declaring instance variables for text fields, labels, combo boxes, buttons, and a random number generator
    JTextField tfname, tffname, tfadd, tfph, tfem, tfX, tfXII, tfad;
    JLabel ei;
    Random ran = new Random();
    JDateChooser d;
    JComboBox<String> cb, cbb;
    JButton sub, can;
    long first4 = ((ran.nextLong() % 9000L) + 1000L);

    // Constructor to initialize the frame and its components
    AddTeacher() {
        setSize(1920, 1080);  // Setting the size of the frame
        setLayout(null);  // Using absolute layout

        // Heading label
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(470, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        // Name label and text field
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(70, 100, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 100, 150, 30);
        add(tfname);

        // Father's Name label and text field
        JLabel lblfname = new JLabel("Father's Name :");
        lblfname.setBounds(400, 100, 170, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 100, 150, 30);
        add(tffname);

        // Employee ID label and display
        JLabel lblrn = new JLabel("Employee ID :");
        lblrn.setBounds(50, 200, 170, 30);
        lblrn.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrn);

        ei = new JLabel("101" + first4);
        ei.setBounds(200, 200, 170, 30);
        ei.setFont(new Font("serif", Font.BOLD, 20));
        add(ei);

        // Date of Birth label and date chooser
        JLabel lbldob = new JLabel("Date Of Birth :");
        lbldob.setBounds(400, 200, 170, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        d = new JDateChooser();
        d.setBounds(600, 200, 150, 30);
        add(d);

        // Address label and text field
        JLabel lbladd = new JLabel("Address :");
        lbladd.setBounds(60, 300, 100, 30);
        lbladd.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladd);

        tfadd = new JTextField();
        tfadd.setBounds(200, 300, 150, 30);
        add(tfadd);

        // Phone Number label and text field
        JLabel lblph = new JLabel("Phone Number :");
        lblph.setBounds(400, 300, 170, 30);
        lblph.setFont(new Font("serif", Font.BOLD, 20));
        add(lblph);

        tfph = new JTextField();
        tfph.setBounds(600, 300, 150, 30);
        add(tfph);

        // Email Id label and text field
        JLabel lblem = new JLabel("Email Id :");
        lblem.setBounds(60, 400, 100, 30);
        lblem.setFont(new Font("serif", Font.BOLD, 20));
        add(lblem);

        tfem = new JTextField();
        tfem.setBounds(200, 400, 150, 30);
        add(tfem);

        // Class X(%) label and text field
        JLabel lblX = new JLabel("Class X(%) :");
        lblX.setBounds(400, 400, 170, 30);
        lblX.setFont(new Font("serif", Font.BOLD, 20));
        add(lblX);

        tfX = new JTextField();
        tfX.setBounds(600, 400, 150, 30);
        add(tfX);

        // Class XII(%) label and text field
        JLabel lblXII = new JLabel("Class XII(%) :");
        lblXII.setBounds(50, 500, 200, 30);
        lblXII.setFont(new Font("serif", Font.BOLD, 20));
        add(lblXII);

        tfXII = new JTextField();
        tfXII.setBounds(200, 500, 150, 30);
        add(tfXII);

        // Aadhaar Number label and text field
        JLabel lblad = new JLabel("Aadhaar Number :");
        lblad.setBounds(400, 500, 170, 30);
        lblad.setFont(new Font("serif", Font.BOLD, 20));
        add(lblad);

        tfad = new JTextField();
        tfad.setBounds(600, 500, 150, 30);
        add(tfad);

        // Qualification label and combo box
        JLabel lblc = new JLabel("Qualification :");
        lblc.setBounds(830, 100, 170, 30);
        lblc.setFont(new Font("serif", Font.BOLD, 20));
        add(lblc);

        String[] course = {"UG", "PG", "PhD"};
        cb = new JComboBox<>(course);
        cb.setBounds(1030, 100, 170, 30);
        cb.setBackground(Color.WHITE);
        add(cb);

        // Department label and combo box
        JLabel lblbr = new JLabel("Department :");
        lblbr.setBounds(830, 200, 170, 30);
        lblbr.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbr);

        String[] branch = {"CSE", "ECE", "IT", "ME", "ASE", "AI/ML", "Arts", "Commerce", "Science"};
        cbb = new JComboBox<>(branch);
        cbb.setBounds(1030, 200, 170, 30);
        cbb.setBackground(Color.WHITE);
        add(cbb);

        // Submit button
        sub = new JButton("SUBMIT");
        sub.setBounds(830, 300, 120, 30);
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this);
        sub.setFont(new Font("serif", Font.BOLD, 15));
        add(sub);

        // Cancel button
        can = new JButton("CANCEL");
        can.setBounds(1030, 300, 120, 30);
        can.setBackground(Color.BLACK);
        can.setForeground(Color.WHITE);
        can.addActionListener(this);
        can.setFont(new Font("serif", Font.BOLD, 15));
        add(can);

        setVisible(true);  // Make the frame visible
    }

    // Handle button actions
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sub) {  // If submit button is clicked
            // Get all the input values
            String name = tfname.getText();
            String fname = tffname.getText();
            String roll = ei.getText();
            String dob = ((JTextField) d.getDateEditor().getUiComponent()).getText();
            String add = tfadd.getText();
            String ph = tfph.getText();
            String email = tfem.getText();
            String x = tfX.getText();
            String xii = tfXII.getText();
            String adhar = tfad.getText();
            String c = (String) cb.getSelectedItem();
            String br = (String) cbb.getSelectedItem();

            try {
                // Insert the teacher details into the database
                String query = "insert into Teacher values('" + name + "','" + fname + "','" + roll + "','" + dob + "','" + add + "','" + ph + "','" + email + "','" + x + "','" + xii + "','" + adhar + "','" + c + "','" + br + "')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);  // Close the frame
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {  // If cancel button is clicked
            setVisible(false);  // Close the frame
        }
    }

    public static void main(String[] args) {
        new AddTeacher();  // Create and show the frame
    }
}
