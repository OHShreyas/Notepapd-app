import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileA extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton saveButton;

    public FileA() {
        super("File Appender");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        getContentPane().add(textArea, BorderLayout.CENTER);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        getContentPane().add(saveButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == saveButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    FileWriter writer = new FileWriter(file, true);
                    writer.write(textArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Text saved to file.");
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving text to file.");
                }
            }
        }
    }

    public static void main(String[] args) {
        new FileA();
    }
}
