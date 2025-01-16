package erpsystem;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {
        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image); // Add the image to the frame

        // Initialize and start the thread
        t = new Thread(this);
        t.start();
        
        setVisible(true); // Make the frame visible
        int x = 1;
        
        // Gradually resize the frame for the splash effect
        for (int i = 2; i <= 400; i += 4, x += 1) {
            setLocation(550 - ((i + x) / 2), 280 - (i / 2)); // Set the location of the frame
            setSize(i + 3 * x, i + x / 2); // Set the size of the frame
            try {
                Thread.sleep(10); // Pause for 10 milliseconds
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        try {
            Thread.sleep(5000); // Pause for 5 seconds
            setVisible(false); // Hide the splash screen
            new Login(); // Show the login screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash(); // Create and show the splash screen
    }
}
