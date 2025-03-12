package GUI.Panel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BLL.BUS.KhachHangBLL;
import DTO.KhachHangDTO;

import java.awt.*;
import java.util.List;

public class KhachHang extends JPanel {
    JPanel pnlTop, pnlBot;
    JTable tbl;
    KhachHangBLL khachHangBLL;

    public KhachHang() {
        khachHangBLL = new KhachHangBLL();
        initComponent();
        loadData();
    }

    private void initComponent() {
        // Panel trên
        pnlTop = new JPanel();
        pnlTop.setPreferredSize(new Dimension(0, 80));
        
        TopNav topNav = new TopNav();
        pnlTop.add(topNav);

        // Panel dưới
        pnlBot = new JPanel(new BorderLayout());
        pnlBot.setPreferredSize(new Dimension(0, 500));

        // Tạo JTable
        tbl = new JTable();
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl.setRowHeight(35);
        tbl.setFocusable(false);

        // Tô màu header bảng
        JTableHeader header = tbl.getTableHeader();
        header.setPreferredSize(new Dimension(0,40));
        header.setBackground(new Color(100, 149, 237)); // Màu nền header (Cornflower Blue)
        header.setForeground(Color.WHITE); // Màu chữ header
        header.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Font chữ header

        // Thêm JScrollPane chứa bảng
        JScrollPane scrollPane = new JScrollPane(tbl);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        pnlBot.setLayout(new BorderLayout());
        pnlBot.setBorder(new EmptyBorder(10, 15, 10, 15));
        pnlBot.add(scrollPane, BorderLayout.CENTER);

        // Thiết lập layout cho KhachHang
        this.setLayout(new BorderLayout());
        this.add(topNav, BorderLayout.NORTH);
        this.add(pnlBot, BorderLayout.CENTER);
    }

    private void loadData() {
        // Lấy dữ liệu từ BLL
        List<KhachHangDTO> khachHangList = khachHangBLL.getAllKhachHang();
        String[] columnNames = { "Mã KH", "Tên", "Địa Chỉ", "SĐT", "Email" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Thêm dữ liệu vào bảng
        for (KhachHangDTO kh : khachHangList) {
            Object[] rowData = { kh.getMaKH(), kh.getTen(), kh.getDiaChi(), kh.getSdt(), kh.getEmail() };
            model.addRow(rowData);
        }

        tbl.setModel(model);
    }
}
