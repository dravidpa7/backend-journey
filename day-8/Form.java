//import java awt for GUI components form submission

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Form {
    JFrame frame;
    JTextField nameField, emailField;   
    JButton submitButton;

    public Form() {
        frame = new JFrame("User Form");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameLabel.setBounds(10, 20, 80, 25);
        nameField.setBounds(100, 20, 165, 25);
        
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        submitButton = new JButton("Submit");
        emailLabel.setBounds(10, 60, 80, 25);
        emailField.setBounds(100, 60, 165, 25);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                JOptionPane.showMessageDialog(frame, "Submitted:\nName: " + name + "\nEmail: " + email);
            }
        });

        submitButton.setBounds(10, 100, 80, 25);

        
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(submitButton);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Form();
    }
}
