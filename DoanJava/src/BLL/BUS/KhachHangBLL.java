package BLL.BUS;

import java.util.List;

import DAO.KhachHangDao;
import DTO.KhachHangDTO;

public class KhachHangBLL {
    private KhachHangDao khachHangDao;

    public KhachHangBLL() {
        khachHangDao = new KhachHangDao();
    }

    // Thêm khách hàng mới
    public boolean addKhachHang(KhachHangDTO khachHang) {
        // Kiểm tra logic kinh doanh ở đây nếu cần
        return khachHangDao.addKhachHang(khachHang);
    }

    // Cập nhật thông tin khách hàng
    public boolean updateKhachHang(KhachHangDTO khachHang) {
        // Kiểm tra logic kinh doanh ở đây nếu cần
        return khachHangDao.updateKhachHang(khachHang);
    }

    // Xóa khách hàng
    public boolean deleteKhachHang(int maKH) {
        // Kiểm tra logic kinh doanh ở đây nếu cần
        return khachHangDao.deleteKhachHang(maKH);
    }

    // Lấy thông tin khách hàng theo mã
    public KhachHangDTO getKhachHangById(int maKH) {
        return khachHangDao.getKhachHangById(maKH);
    }

    // Lấy danh sách tất cả khách hàng
    public List<KhachHangDTO> getAllKhachHang() {
        return khachHangDao.getAllKhachHang();
    }
}
