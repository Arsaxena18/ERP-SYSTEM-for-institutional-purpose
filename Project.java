package erpsystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        // Set the size of the window to the full screen size
        setSize(1920, 1080);

        // Load and scale the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 700);
        add(image);

        // Create the menu bar
        JMenuBar mb = new JMenuBar();

        // Add "New Information" menu
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        // Add "New Faculty Information" menu item
        JMenuItem facInfo = new JMenuItem("New Faculty Information");
        facInfo.setBackground(Color.WHITE);
        facInfo.setForeground(Color.BLACK);
        facInfo.addActionListener(this);
        newInfo.add(facInfo);

        // Add "New Student Information" menu item
        JMenuItem stdInfo = new JMenuItem("New Student Information");
        stdInfo.setBackground(Color.WHITE);
        stdInfo.setForeground(Color.BLACK);
        stdInfo.addActionListener(this);
        newInfo.add(stdInfo);

        // Add "View Details" menu
        JMenu dt = new JMenu("View Details");
        dt.setForeground(Color.BLACK);
        mb.add(dt);

        // Add "View Faculty Details" menu item
        JMenuItem facdt = new JMenuItem("View Faculty Details");
        facdt.setBackground(Color.WHITE);
        facdt.setForeground(Color.BLACK);
        facdt.addActionListener(this);
        dt.add(facdt);

        // Add "View Student Details" menu item
        JMenuItem stddt = new JMenuItem("View Student Details");
        stddt.setBackground(Color.WHITE);
        stddt.setForeground(Color.BLACK);
        stddt.addActionListener(this);
        dt.add(stddt);

        // Add "Apply Leave" menu
        JMenu lv = new JMenu("Apply Leave");
        lv.setForeground(Color.BLACK);
        mb.add(lv);

        // Add "Faculty Leave" menu item
        JMenuItem faclv = new JMenuItem("Faculty Leave");
        faclv.setBackground(Color.WHITE);
        faclv.setForeground(Color.BLACK);
        faclv.addActionListener(this);
        lv.add(faclv);

        // Add "Student Leave" menu item
        JMenuItem stdlv = new JMenuItem("Student Leave");
        stdlv.setBackground(Color.WHITE);
        stdlv.setForeground(Color.BLACK);
        stdlv.addActionListener(this);
        lv.add(stdlv);

        // Add "Leave Details" menu
        JMenu lvdt = new JMenu("Leave Details");
        lvdt.setForeground(Color.BLACK);
        mb.add(lvdt);

        // Add "Faculty Leave Details" menu item
        JMenuItem faclvdt = new JMenuItem("Faculty Leave Details");
        faclvdt.setBackground(Color.WHITE);
        faclvdt.setForeground(Color.BLACK);
        faclvdt.addActionListener(this);
        lvdt.add(faclvdt);

        // Add "Student Leave Details" menu item
        JMenuItem stdlvdt = new JMenuItem("Student Leave Details");
        stdlvdt.setBackground(Color.WHITE);
        stdlvdt.setForeground(Color.BLACK);
        stdlvdt.addActionListener(this);
        lvdt.add(stdlvdt);

        // Add "Examination" menu
        JMenu exams = new JMenu("Examination");
        exams.setForeground(Color.BLACK);
        mb.add(exams);

        // Add "Results" menu item
        JMenuItem exmdt = new JMenuItem("Results");
        exmdt.setBackground(Color.WHITE);
        exmdt.setForeground(Color.BLACK);
        exmdt.addActionListener(this);
        exams.add(exmdt);

        // Add "Upload marks" menu item
        JMenuItem marks = new JMenuItem("Upload marks");
        marks.setBackground(Color.WHITE);
        marks.setForeground(Color.BLACK);
        marks.addActionListener(this);
        exams.add(marks);

        // Add "Update Details" menu
        JMenu update = new JMenu("Update Details");
        update.setForeground(Color.BLACK);
        mb.add(update);

        // Add "Update Faculty Details" menu item
        JMenuItem upfd = new JMenuItem("Update Faculty Details");
        upfd.setBackground(Color.WHITE);
        upfd.setForeground(Color.BLACK);
        upfd.addActionListener(this);
        update.add(upfd);

        // Add "Update Student Details" menu item
        JMenuItem upsd = new JMenuItem("Update Student Details");
        upsd.setBackground(Color.WHITE);
        upsd.setForeground(Color.BLACK);
        upsd.addActionListener(this);
        update.add(upsd);

        // Add "Fees" menu
        JMenu fee = new JMenu("Fees");
        fee.setForeground(Color.BLACK);
        mb.add(fee);

        // Add "Fee Structure" menu item
        JMenuItem feest = new JMenuItem("Fee Structure");
        feest.setBackground(Color.WHITE);
        feest.setForeground(Color.BLACK);
        feest.addActionListener(this);
        fee.add(feest);

        // Add "Fee Submission" menu item
        JMenuItem feesb = new JMenuItem("Fee Submission");
        feesb.setBackground(Color.WHITE);
        feesb.setForeground(Color.BLACK);
        feesb.addActionListener(this);
        fee.add(feesb);

        // Add "Utility" menu
        JMenu ut = new JMenu("Utility");
        ut.setForeground(Color.BLACK);
        mb.add(ut);

        // Add "Notepad" menu item
        JMenuItem nt = new JMenuItem("Notepad");
        nt.setBackground(Color.WHITE);
        nt.setForeground(Color.BLACK);
        nt.addActionListener(this);
        ut.add(nt);

        // Add "Calculator" menu item
        JMenuItem cal = new JMenuItem("Calculator");
        cal.setBackground(Color.WHITE);
        cal.setForeground(Color.BLACK);
        cal.addActionListener(this);
        ut.add(cal);

        // Add "About" menu
        JMenu abt = new JMenu("About");
        abt.setForeground(Color.BLACK);
        mb.add(abt);

        // Add "About" menu item
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.setForeground(Color.BLACK);
        ab.addActionListener(this);
        abt.add(ab);

        // Add "Exit" menu
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        // Add "Exit" menu item
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.setForeground(Color.BLACK);
        ex.addActionListener(this);
        exit.add(ex);

        // Set the menu bar to the frame
        setJMenuBar(mb);
        setVisible(true);
    }

    // Handle actions performed on menu items
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();

        // Close the application if "Exit" is selected
        if (msg.equals("Exit")) {
            setVisible(false);
            dispose();
        } else if (msg.equals("Calculator")) {
            // Open Calculator
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            // Open Notepad
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeavedt();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeavedt();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacherdt();
        } else if (msg.equals("Update Student Details")) {
            new Updatestdt();
        } else if (msg.equals("Upload marks")) {
            new Marks();
        } else if (msg.equals("Results")) {
            new Result();
        } else if (msg.equals("Fee Structure")) {
            new FeeS();
        } else if (msg.equals("About")) {
            new About();
        }else if (msg.equals("Fee Submission")) {
            new FeeForm();
    }
    }
    public static void main(String[] args) {
        new Project();
    }
}
