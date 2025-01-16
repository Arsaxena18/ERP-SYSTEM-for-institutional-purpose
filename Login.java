package erpsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField tfusername, tfpassword;

    Login() {
        // Set the background color of the content pane to white
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // Use null layout for custom positioning
        
        // Create and position the "Username" label
        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);
        
        // Create and position the text field for the username
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        // Create and position the "Password" label
        JLabel lblpassword = new JLabel("Password :");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);
        
        // Create and position the text field for the password
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        // Create and position the login button
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif", Font.BOLD, 15));
        add(login);
        
        // Create and position the cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);
        
        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 100, 200);
        add(image);
        
        // Set the size and location of the login window
        setSize(500, 300);
        setLocation(400, 200);
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            // Query to check the login credentials
            String query = "select * from login where username = '" + username + "' and password='" + password + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    setVisible(false); // Hide the login window
                    new Project(); // Show the main project window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false); // Hide the login window
                }
                
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false); // Hide the login window
        }
    }

    public static void main(String[] args) {
        new Login(); // Create and show the login window
    }
}
