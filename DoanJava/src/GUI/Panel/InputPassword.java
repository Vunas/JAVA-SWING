package GUI.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class InputPassword extends JPanel {
    JPasswordField passwordField;
    JLabel lblTitle;

    public InputPassword(String title) {
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(new Color(255, 255, 255));
        this.setBorder(new EmptyBorder(0, 10, 5, 10));
        this.setPreferredSize(new Dimension(100, 100));
        lblTitle = new JLabel(title);
        passwordField = new JPasswordField();
        this.add(lblTitle);
        this.add(passwordField);
    }
}
