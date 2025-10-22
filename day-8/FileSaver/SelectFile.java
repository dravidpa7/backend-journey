package FileSaver;
import javax.swing.event.*;
// Show the all txt files in the current directory and allow user to select one file using JFileChooser
// and display the selected file name in a JOptionPane
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectFile {
    JFrame frame;
    JButton selectButton;
    JButton createNewFileButton;
    JButton undoButton;
    JButton redoButton;

    SelectFile() {
        frame = new JFrame("Select File");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        createNewFileButton = new JButton("Create File");
        createNewFileButton.setBounds(100, 110, 120, 30);

        createNewFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create object of FileSave class
                new FileSave();

            }
        });


        selectButton = new JButton("Select File");
        selectButton.setBounds(100, 70, 100, 30);

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new java.io.File("."));
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text", "txt"));

                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                     java.io.File selectedFile = fileChooser.getSelectedFile();
                    // Read the file content and display in an editable JTextArea inside a JScrollPane
                    try {
                        final java.nio.file.Path path = selectedFile.toPath();
                        String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);

                        final JTextArea textArea = new JTextArea(content);
                        textArea.setEditable(true);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(700, 500));

                        // Initialize the OperationStack with initial content
                        OperationStack.init(textArea.getText());

                        // Create document listener with word boundary detection
                        final DocumentListener docListener = new DocumentListener() {
                            private boolean isWordBoundary = false;
                            private Timer timer = new Timer(1000, e -> {
                                if (isWordBoundary) {
                                    OperationStack.recordBeforeChange(textArea.getText());
                                    isWordBoundary = false;
                                }
                            });

                            {
                                timer.setRepeats(false);
                            }

                            private void handleChange(DocumentEvent e) {
                                try {
                                    int offset = e.getOffset();
                                    String content = textArea.getText();
                                    
                                    // Check if we're at a word boundary (space, punctuation)
                                    if (offset > 0 && offset < content.length()) {
                                        char currentChar = content.charAt(offset);
                                        char prevChar = content.charAt(offset - 1);
                                        
                                        if (Character.isWhitespace(currentChar) || 
                                            Character.isWhitespace(prevChar) ||
                                            isPunctuation(currentChar) ||
                                            isPunctuation(prevChar)) {
                                            isWordBoundary = true;
                                            timer.restart();
                                        }
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }

                            private boolean isPunctuation(char c) {
                                return !Character.isLetterOrDigit(c) && !Character.isWhitespace(c);
                            }

                            public void insertUpdate(DocumentEvent e) {
                                handleChange(e);
                            }
                            public void removeUpdate(DocumentEvent e) {
                                handleChange(e);
                            }
                            public void changedUpdate(DocumentEvent e) {
                                // Plain text components don't fire these events
                            }
                        };

                        // Add document listener to track changes
                        textArea.getDocument().addDocumentListener(docListener);

                        // Create a small editor window with Save/Close buttons
                        final JDialog editor = new JDialog(frame, "Edit: " + selectedFile.getName(), true);
                        editor.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        editor.setLayout(new BorderLayout());
                        editor.add(scrollPane, BorderLayout.CENTER);

                        JButton undoBtn = new JButton("Undo");
                        JButton redoBtn = new JButton("Redo");
                        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        topPanel.add(undoBtn);
                        topPanel.add(redoBtn);
                        editor.add(topPanel, BorderLayout.NORTH);

                        undoBtn.addActionListener(ev -> {
                            // Remove listener before making changes
                            textArea.getDocument().removeDocumentListener(docListener);
                            String prev = OperationStack.undo(textArea.getText());
                            textArea.setText(prev);
                            // Re-add listener after changes
                            textArea.getDocument().addDocumentListener(docListener);
                        });
                        
                        redoBtn.addActionListener(ev -> {
                            // Remove listener before making changes
                            textArea.getDocument().removeDocumentListener(docListener);
                            String next = OperationStack.redo(textArea.getText());
                            textArea.setText(next);
                            // Re-add listener after changes
                            textArea.getDocument().addDocumentListener(docListener);
                        });


                        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JButton saveBtn = new JButton("Save");
                        JButton closeBtn = new JButton("Close");
                        buttonPanel.add(saveBtn);
                        buttonPanel.add(closeBtn);
                        editor.add(buttonPanel, BorderLayout.SOUTH);

                        // Save action: write text back to file
                        saveBtn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                try {
                                    String newText = textArea.getText();

                                    java.nio.file.Files.write(path, newText.getBytes(java.nio.charset.StandardCharsets.UTF_8));
                                    JOptionPane.showMessageDialog(editor, "File saved successfully.");
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(editor, "Failed to save file: " + ex.getMessage());
                                    ex.printStackTrace();
                                }
                            }
                        });

                        // Close action
                        closeBtn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                editor.dispose();
                            }
                        });

                        editor.pack();
                        editor.setLocationRelativeTo(frame);
                        editor.setVisible(true);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Failed to read file: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
        });

        // open the file show text content in a JTextArea inside a JScrollPane

        frame.add(createNewFileButton);
        frame.add(selectButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectFile();
    }    
}
