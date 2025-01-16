package erpsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Result extends JFrame implements ActionListener {
    JTextField sc;
    JButton sub, can;
    JTable tb;

    Result() {
        setSize(1000, 500);  // Setting frame size
        setLocation(150, 100);  // Setting frame location
        setLayout(null);  // Using absolute layout

        getContentPane().setBackground(Color.WHITE);  // Setting background color

        JLabel heading = new JLabel("Check Result ");
        heading.setBounds(70, 20, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        sc = new JTextField();
        sc.setBounds(60, 80, 200, 20);
        add(sc);

        sub = new JButton("RESULT");
        sub.setBounds(270, 80, 120, 30);
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setFont(new Font("serif", Font.BOLD, 15));
        sub.addActionListener(this);
        add(sub);

        can = new JButton("CANCEL");
        can.setBounds(400, 80, 120, 30);
        can.setBackground(Color.BLACK);
        can.setForeground(Color.WHITE);
        can.setFont(new Font("serif", Font.BOLD, 15));
        can.addActionListener(this);
        add(can);

        tb = new JTable();
        tb.setFont(new Font("Serif", Font.PLAIN, 16));

        JScrollPane jsp = new JScrollPane(tb);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from stdus");
            tb.setModel(DbUtils.resultSetToTableModel(rs));  // Setting table model using DbUtils
        } catch (Exception e) {
            e.printStackTrace();
        }

        tb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = tb.getSelectedRow();
                sc.setText(tb.getModel().getValueAt(row, 2).toString());  // Setting text field with selected student's ID
            }
        });

        setVisible(true);  // Setting frame visibility
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sub) {
            setVisible(false);
            new M(sc.getText());  // Opening new window with student ID passed to constructor of M class
        } else {
            setVisible(false);  // Hiding the frame if CANCEL button is clicked
        }
    }

    public static void main(String[] args) {
        new Result();  // Creating instance of Result frame
    }
}
