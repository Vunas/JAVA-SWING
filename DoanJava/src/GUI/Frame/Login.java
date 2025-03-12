package GUI.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.formdev.flatlaf.FlatClientProperties;

import GUI.Panel.InputPassword;
import GUI.Panel.InputText;

import java.awt.*;

public class Login extends JFrame {
    JPanel pnlImg, pnlMain, pnlInput;
    InputText txt;
    InputPassword psw;
    JLabel lblTitle, lblForgot;
    JButton btnLogin;

    public Login(){
        initComponent();
    }

    private void initComponent(){
        this.setSize(new Dimension(1000, 500));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0, 0));
        this.setTitle("Đăng nhập");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel imglbl = new JLabel();
        imglbl.setIcon(new ImageIcon("resources/img/login.jpg"));
        pnlImg = new JPanel();
        pnlImg.setBackground(Color.white);
        pnlImg.setBorder(new EmptyBorder(20, 0, 0, 0));
        pnlImg.setPreferredSize(new Dimension(500, 740));
        pnlImg.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        pnlImg.add(imglbl);

        pnlMain = new JPanel();
        pnlMain.setBackground(Color.white);
        pnlMain.setBorder(new EmptyBorder(20, 0, 0, 0));
        pnlMain.setPreferredSize(new Dimension(500, 740));
        pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        lblTitle = new JLabel("ĐĂNG NHẬP");
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 20));
        pnlMain.add(lblTitle, BorderLayout.CENTER);

        pnlInput = new JPanel();
        pnlInput.setBackground(Color.BLACK);
        pnlInput.setPreferredSize(new Dimension(400, 200));
        pnlInput.setLayout(new GridLayout(2, 1));

        txt = new InputText("Tên đăng nhập");
        psw = new InputPassword("Mật khẩu");
        pnlInput.add(txt);
        pnlInput.add(psw);
        pnlMain.add(pnlInput, BorderLayout.CENTER);

        lblForgot = new JLabel("Quên mật khẩu?");
        lblForgot.setPreferredSize(new Dimension(380, 50));
        lblForgot.setFont(new Font("Roboto", Font.ITALIC, 18));
        lblForgot.setHorizontalAlignment(JLabel.RIGHT);
        pnlMain.add(lblForgot);

        lblForgot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblForgot.setForeground(Color.blue); // Màu khi hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblForgot.setForeground(Color.BLACK); // Màu gốc
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(null,"Vì lí do bảo mật, bạn hãy liên hệ quản trị viên hoặc sếp để thiết lập lại mật khẩu!");
            }
        });

        pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));        
        JPanel pnlForgot = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pnlForgot.setPreferredSize(new Dimension(380, 50));
        pnlForgot.setBackground(Color.white);
        pnlForgot.add(lblForgot);
        pnlMain.add(pnlForgot);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Roboto", Font.BOLD, 16));
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE); 
        btnLogin.setPreferredSize(new Dimension(380, 55));
        btnLogin.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        pnlMain.add(btnLogin, BorderLayout.LINE_END);

        this.add(pnlImg, BorderLayout.LINE_START);
        this.add(pnlMain, BorderLayout.CENTER);
    }

    // public static void main(String[] args) {
    //     FlatLightLaf.setup(); // Thiết lập FlatLaf
    //     new Login().setVisible(true);
    // }
}
