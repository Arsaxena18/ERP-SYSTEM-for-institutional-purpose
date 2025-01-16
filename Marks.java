package erpsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {

    Choice crn;
    JComboBox<String> cbsem;
    JTextField sub1, sub2, sub3, sub4, sub5, sub6;
    JTextField tfm1, tfm2, tfm3, tfm4, tfm5, tfm6;
    JButton sub, can;

    Marks() {
        setSize(1000,500);  // Setting frame size
        setLocation(150,100);  // Setting frame location
        setLayout(null);  // Using absolute layout

        getContentPane().setBackground(Color.WHITE);  // Setting background color

        // Adding image to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 40, 400, 300);
        add(image);

        // Adding heading label
        JLabel heading = new JLabel("Enter Marks");
        heading.setBounds(70, 20, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        // Adding label and choice for selecting Roll Number
        JLabel lbrn = new JLabel("Select Roll Number:");
        lbrn.setBounds(60, 80, 150, 20);
        lbrn.setFont(new Font("serif", Font.BOLD, 15));
        add(lbrn);

        crn = new Choice();
        crn.setBounds(220, 80, 150, 20);
        add(crn);

        // Fetching Roll Numbers from database and adding to Choice component
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from stdus");
            while (rs.next()) {
                crn.add(rs.getString("rn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adding label and JComboBox for selecting Semester
        JLabel lsem = new JLabel("Select Semester:");
        lsem.setBounds(60, 110, 150, 20);
        lsem.setFont(new Font("serif", Font.BOLD, 16));
        add(lsem);

        String[] sem = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
        cbsem = new JComboBox<>(sem);
        cbsem.setBounds(220, 110, 150, 20);
        cbsem.setBackground(Color.WHITE);
        add(cbsem);

        // Adding labels and text fields for entering Subject names and Marks
        JLabel lsub = new JLabel("Select Subject:");
        lsub.setBounds(60, 150, 150, 20);
        lsub.setFont(new Font("serif", Font.BOLD, 15));
        add(lsub);

        sub1 = new JTextField();
        sub1.setBounds(60, 200, 200, 20);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(60, 230, 200, 20);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(60, 260, 200, 20);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(60, 290, 200, 20);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(60, 320, 200, 20);
        add(sub5);

        sub6 = new JTextField();
        sub6.setBounds(60, 350, 200, 20);
        add(sub6);

        JLabel lmar = new JLabel("Enter Marks:");
        lmar.setBounds(300, 150, 150, 20);
        lmar.setFont(new Font("serif", Font.BOLD, 15));
        add(lmar);

        tfm1 = new JTextField();
        tfm1.setBounds(300, 200, 200, 20);
        add(tfm1);

        tfm2 = new JTextField();
        tfm2.setBounds(300, 230, 200, 20);
        add(tfm2);

        tfm3 = new JTextField();
        tfm3.setBounds(300, 260, 200, 20);
        add(tfm3);

        tfm4 = new JTextField();
        tfm4.setBounds(300, 290, 200, 20);
        add(tfm4);

        tfm5 = new JTextField();
        tfm5.setBounds(300, 320, 200, 20);
        add(tfm5);

        tfm6 = new JTextField();
        tfm6.setBounds(300, 350, 200, 20);
        add(tfm6);

        // Adding buttons for submitting and canceling
        sub = new JButton("SUBMIT");
        sub.setBounds(100, 400, 120, 30);
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setFont(new Font("serif", Font.BOLD, 15));
        sub.addActionListener(this);
        add(sub);

        can = new JButton("CANCEL");
        can.setBounds(300, 400, 120, 30);
        can.setBackground(Color.BLACK);
        can.setForeground(Color.WHITE);
        can.setFont(new Font("serif", Font.BOLD, 15));
        can.addActionListener(this);
        add(can);

        setVisible(true);  // Setting frame visibility
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sub) {  // If SUBMIT button is clicked
            try {
                Conn c = new Conn();
                // Constructing queries to insert subject details and marks into respective tables
                String query1 = "insert into sub values ('" + crn.getSelectedItem() + "', '" + cbsem.getSelectedItem() + "', '" + sub1.getText() + "', '" + sub2.getText() + "', '" + sub3.getText() + "', '" + sub4.getText() + "', '" + sub5.getText() + "', '" + sub6.getText() + "')";
                String query2 = "insert into marks values ('" + crn.getSelectedItem() + "', '" + cbsem.getSelectedItem() + "', '" + tfm1.getText() + "', '" + tfm2.getText() + "', '" + tfm3.getText() + "', '" + tfm4.getText() + "', '" + tfm5.getText() + "', '" + tfm6.getText() + "')";
                c.s.executeUpdate(query1);  // Executing query to insert subject details
                c.s.executeUpdate(query2);  // Executing query to insert marks
                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");  // Displaying success message
                setVisible(false);  // Hiding frame
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == can) {  // If CANCEL button is clicked
            setVisible(false);  // Hiding frame
        }
    }

    public static void main(String[] args) {
        new Marks();  // Creating instance of Marks frame
    }
}
