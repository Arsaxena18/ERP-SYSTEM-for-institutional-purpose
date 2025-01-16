package erpsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class FeeForm extends JFrame implements ActionListener {

    Choice crn;
    JComboBox c, br, cbsemester;
    JLabel labeltotal;
    JButton update, pay, back;
    
    FeeForm() {
        setSize(900, 500);  // Setting frame size
        setLocation(180, 100);  // Setting frame location
        setLayout(null);  // Using absolute layout
        
        getContentPane().setBackground(Color.WHITE);  // Setting background color
        
        // Adding image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);
        
        // Roll Number selection
        JLabel lblrollnumber = new JLabel("Select Roll No");
        lblrollnumber.setBounds(40, 60, 150, 20);
        lblrollnumber.setFont(new Font("Serif", Font.BOLD, 16));
        add(lblrollnumber);
        
        crn = new Choice();
        crn.setBounds(200, 60, 150, 20);
        add(crn);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from stdus");
            while(rs.next()) {
                crn.add(rs.getString("rn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Name and Father's Name display based on Roll Number selection
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Serif", Font.BOLD, 16));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Serif", Font.PLAIN, 16));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Serif", Font.BOLD, 16));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200, 140, 150, 20);
        labelfname.setFont(new Font("Serif", Font.PLAIN, 16));
        add(labelfname);
        
        // Fetching student details from database based on selected Roll Number
        try {
            Conn c = new Conn();
            String query = "select * from stdus where rn='"+crn.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // ItemListener for Choice component to dynamically update student details
        crn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from stdus where rollno='"+crn.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Course selection
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Serif", Font.BOLD, 16));
        add(lblcourse);
        
        String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        c = new JComboBox(course);
        c.setBounds(200, 180, 150, 20);
        c.setBackground(Color.WHITE);
        add(c);
        
        // Branch selection
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 220, 150, 20);
        lblbranch.setFont(new Font("Serif", Font.BOLD, 16));
        add(lblbranch);
        
        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        br= new JComboBox(branch);
        br.setBounds(200, 220, 150, 20);
        br.setBackground(Color.WHITE);
        add(br);
        
        // Semester selection
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40, 260, 150, 20);
        lblsemester.setFont(new Font("Serif", Font.BOLD, 16));
        add(lblsemester);
        
        String semester[] = {"sem1", "sem2", "sem3", "sem4", "sem5", "sem6", "sem7", "sem8" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 260, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        // Total Payable fee display
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Serif", Font.BOLD, 16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Serif", Font.PLAIN, 16));
        add(labeltotal);
        
        // Buttons for actions
        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Serif", Font.BOLD, 15));
        add(update);
        
        pay = new JButton("Pay Fee");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Serif", Font.BOLD, 15));
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Serif", Font.BOLD, 15));
        add(back);
        
        setVisible(true);  // Setting frame visibility
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            // Update button action
            String course = (String) c.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fees where course = '"+course+"'");
                while(rs.next()) {
                    labeltotal.setText(rs.getString(semester));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pay) {
            // Pay Fee button action
            String rn = crn.getSelectedItem();
            String course = (String) c.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) br.getSelectedItem();
            String total = labeltotal.getText();
            
            try {
                Conn c = new Conn();
                
                // Inserting fee payment details into database
                String query = "insert into collegefee values('"+rn+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);  // Hiding the current frame
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);  // Hiding the current frame for the 'Back' button
        }
    }

    public static void main(String[] args) {
        new FeeForm();  // Creating an instance of FeeForm frame
    }
}
