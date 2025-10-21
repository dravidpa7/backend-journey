// Crete a GUI using Swing That takes File name Form user input and creates a file with that name in the current directory
package FileSaver;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FileSave {
    // set some declared values need to used for File extension like .txt .doc .pdf
    JFrame frame;
    JTextField fileName , extensionField;   
    JButton submitButton;

    public FileSave() {
        frame = new JFrame("File Creator");
        frame.setSize(300, 200);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel fileLabel = new JLabel("File Name:");
        fileName = new JTextField();
        fileLabel.setBounds(10, 20, 80, 25);
        fileName.setBounds(100, 20, 165, 25);
        
        JLabel extensionLabel = new JLabel("Extension:");
        extensionField = new JTextField();
        submitButton = new JButton("Create File");
        extensionLabel.setBounds(10, 60, 80, 25);
        extensionField.setBounds(100, 60, 165, 25);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = fileName.getText();
                String extension = extensionField.getText();
                if (name == null) name = "";
                if (extension == null) extension = "";
                if (name.isEmpty() || extension.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter both file name and extension.");
                    return;
                }

                System.out.println(extension);

                // Normalize extension: remove leading dot and trim whitespace
                // String ext = extension.trim();
                // if (ext.startsWith(".")) {
                //     ext = ext.substring(1);
                // }

                // Use equalsIgnoreCase to compare string contents (not reference equality)

                // either we can use .equals -> why this is not working extension == "txt" means reference equality not content equality -> String POOL
                if ("txt".equalsIgnoreCase(extension)) {
                    // System.out.println("inside if");
                    try {
                            File myFile = new File(name + "." + extension);
                            if (myFile.createNewFile()) {
                                JOptionPane.showMessageDialog(frame, "File created: " + myFile.getName());
                            } else {
                                JOptionPane.showMessageDialog(frame, "File already exists.");
                            }
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(frame, "An error occurred.");
                            ex.printStackTrace();
                        }
                    return;
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Unsupported file extension. Only .txt is allowed.");
                    return;
                }
                
            }
        });

        submitButton.setBounds(10, 100, 120, 25);

        
        frame.add(fileLabel);
        frame.add(fileName);
        frame.add(extensionLabel);
        frame.add(extensionField);
        frame.add(submitButton);

        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new FileSave();
    }
}