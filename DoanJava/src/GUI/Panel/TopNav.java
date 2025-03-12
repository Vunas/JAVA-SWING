package GUI.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

public class TopNav extends JPanel {
    JPanel pnlTop, pnlBot;
    JPanel pnlChucNang, pnlSearch;
    JPanel[] top;
    JButton[] btn;

    public TopNav() {
        initComponent();
    }

    private void initComponent() {
        // Panel trên với BorderLayout
        pnlTop = new JPanel(new BorderLayout());
        pnlTop.setBorder(new EmptyBorder(0, 0, 15, 0)); // Khoảng cách bên ngoài
        pnlTop.setBackground(new Color(240, 240, 240)); // Màu nền sáng nhã
        pnlTop.setMinimumSize(new Dimension(200, 0));
        pnlTop.setLayout(new BorderLayout());

        top = new JPanel[3];

        // Panel con đầu tiên (top[0])
        top[0] = new JPanel();
        top[0].setPreferredSize(new Dimension(120, 35));
        top[0].setOpaque(false); // Panel trong suốt
        top[0].add(new JLabel("Khách hàng", new FlatSVGIcon("./resources/icon/user.svg", 0.3f), JLabel.LEFT));

        // Panel con thứ hai (top[1])
        top[1] = new JPanel();
        top[1].setPreferredSize(new Dimension(300, 35));
        // top[1].setBorder(new LineBorder(Color.LIGHT_GRAY)); // Viền mỏng
        JLabel iconSearch= new JLabel(new FlatSVGIcon("./resources/icon/search.svg", 0.3f));
        iconSearch.putClientProperty(FlatClientProperties.STYLE, "arc:99");
        top[1].add(iconSearch);

        JPanel inputSearch= new JPanel();
        inputSearch.setBackground(Color.WHITE);
        inputSearch.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLUE));

        JTextField textSearch = new JTextField(30);
        textSearch.setBorder(null);
        JLabel iconAdvancedSearch= new JLabel(new FlatSVGIcon("./resources/icon/down.svg",0.35f));
        inputSearch.add(textSearch);
        inputSearch.add(iconAdvancedSearch);

        top[1].add(inputSearch);

        // Panel con thứ ba (top[2])
        top[2] = new JPanel(new GridLayout(1, 2,5,0));
        top[2].setPreferredSize(new Dimension(120, 40));
        top[2].setOpaque(false);

        JButton chucNang = new JButton( new FlatSVGIcon("./resources/icon/repair.svg", 0.5f));
        // chucNang.setBackground(new Color(220, 220, 220));
        chucNang.putClientProperty(FlatClientProperties.STYLE, "arc: 12"); // Bo tròn góc
        chucNang.setToolTipText("Chức năng");
        // chucNang.setBorder(new EmptyBorder(10, 0, 10, 0));
        // chucNang.setFocusPainted(false); // Tắt viền khi nhấn
        chucNang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                pnlBot.setVisible(!pnlBot.isVisible());
            }
        });

        JButton refresh = new JButton( new FlatSVGIcon("./resources/icon/refresh.svg", 0.4f));
        
        // refresh.setBackground(new Color(220, 220, 220));
        refresh.setToolTipText("Làm mới");
        refresh.putClientProperty(FlatClientProperties.STYLE, "arc: 12"); // Bo tròn góc
        // refresh.setBorder(new EmptyBorder(10, 0, 10, 0));
        // refresh.setFocusPainted(false); // Tắt viền khi nhấn
        refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                
            }
        });
        
        top[2].add(refresh,RIGHT_ALIGNMENT);
        top[2].add(chucNang,RIGHT_ALIGNMENT);
        
        // Thêm các panel con vào pnlTop
        pnlTop.add(top[0], BorderLayout.WEST);
        pnlTop.add(top[1], BorderLayout.CENTER);
        pnlTop.add(top[2], BorderLayout.EAST);

        // Panel dưới (pnlBot)
        pnlBot = new JPanel(); // Bố cục với khoảng cách 10px giữa các nút
        pnlBot.setPreferredSize(new Dimension(0, 40));

        // Mảng nút
        btn = new JButton[4];

        // Nút "Thêm"
        btn[0] = new JButton("Thêm", new FlatSVGIcon("./resources/icon/add.svg", 0.35f));
        btn[0].setToolTipText("Thêm");

        // Nút "Sửa"
        btn[1] = new JButton("Sửa", new FlatSVGIcon("./resources/icon/fix.svg", 0.35f));
        btn[1].setToolTipText("Sửa");

        // Nút "Xóa"
        btn[2] = new JButton("Xóa", new FlatSVGIcon("./resources/icon/del.svg", 0.35f));
        btn[2].setToolTipText("Xóa");

        btn[3] = new JButton("Chi tiết", new FlatSVGIcon("./resources/icon/detail.svg", 0.6f));
        btn[3].setToolTipText("Chi tiết");

        // Tùy chỉnh giao diện các nút
        for (JButton jButton : btn) {
            jButton.putClientProperty(FlatClientProperties.STYLE, "arc: 12"); // Bo tròn góc
            // jButton.setBorder(new EmptyBorder(0, 20, 0, 20));
            // jButton.setFocusPainted(false); // Tắt viền khi nhấn
            jButton.setBackground(new Color(220, 220, 220)); // Nền nút
            jButton.setPreferredSize(new Dimension(120, 35));
        }

        // Thêm các nút vào pnlBot
        for (JButton button : btn) {
            pnlBot.add(button,LEFT_ALIGNMENT);
        }
        
        // JButton cancel = new JButton( "Làm mới",new FlatSVGIcon("./resources/icon/cancel.svg", 0.4f));
        // cancel.setBackground(new Color(220, 220, 220));
        // cancel.putClientProperty(FlatClientProperties.STYLE, "arc: 12"); // Bo tròn góc
        // cancel.setBorder(new EmptyBorder(10, 0, 10, 0));
        // cancel.setFocusPainted(false); // Tắt viền khi nhấn
        // pnlBot.add(cancel,RIGHT_ALIGNMENT);

        // Thêm pnlTop và pnlBot vào TopNav
        // setMinimumSize(new Dimension(800, 0));
        setPreferredSize(new Dimension(0, 90));
        setLayout(new BorderLayout());
        add(pnlTop, BorderLayout.NORTH);
        add(pnlBot, BorderLayout.SOUTH);
    }
}
