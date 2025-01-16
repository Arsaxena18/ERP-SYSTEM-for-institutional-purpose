package erpsystem;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);  // Setting frame size
        setLocation(300, 100);  // Setting frame location
        getContentPane().setBackground(Color.WHITE);  // Setting background color of content pane
        
        // Loading and displaying an image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);  // Setting bounds for the image
        add(image);  // Adding image to the frame
        
        // Heading for ERP System
        JLabel heading = new JLabel("<html>ERP<br/>System</html>");
        heading.setBounds(70, 20, 300, 130);  // Setting bounds for the heading
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));  // Setting font and size for the heading
        add(heading);  // Adding heading to the frame
        
        // Developer information
        JLabel name = new JLabel("Developed By: Ansh Raj");
        name.setBounds(70, 220, 550, 40);  // Setting bounds for developer name
        name.setFont(new Font("Tahoma", Font.BOLD, 30));  // Setting font and size for developer name
        add(name);  // Adding developer name to the frame
        
        // Roll number and section information
        JLabel rollno = new JLabel("Section/Roll number: H1/14");
        rollno.setBounds(70, 280, 550, 40);  // Setting bounds for roll number
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 30));  // Setting font and size for roll number
        add(rollno);  // Adding roll number to the frame
        
        // University Roll Number information
        JLabel Urn = new JLabel("University Roll No: 2218388");
        Urn.setBounds(70, 340, 550, 40);  // Setting bounds for university roll number
        Urn.setFont(new Font("Tahoma", Font.PLAIN, 20));  // Setting font and size for university roll number
        add(Urn);  // Adding university roll number to the frame
        
        setLayout(null);  // Setting null layout for absolute positioning
        
        setVisible(true);  // Setting frame visibility
    }
    
    public static void main(String[] args) {
        new About();  // Creating an instance of the About frame
    }
}
