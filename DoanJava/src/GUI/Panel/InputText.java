package GUI.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InputText extends JPanel {
    JLabel lblTitle;
    JTextField txtForm;

    public InputText(String title) {  
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(new Color(255, 255, 255));
        this.setBorder(new EmptyBorder(0, 10, 5, 10));
        this.setPreferredSize(new Dimension(100, 100));
        lblTitle = new JLabel(title);  
        txtForm = new JTextField();
        this.add(lblTitle);
        this.add(txtForm);
    }
}
