package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.KhachHangDTO;
import util.JdbcUtil;

public class KhachHangDao {
    
    // Thêm khách hàng mới
    public boolean addKhachHang(KhachHangDTO khachHang) {
        String sql = "INSERT INTO khach_hang (maKH, ten, diaChi, sdt, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JdbcUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, khachHang.getMaKH());
            statement.setString(2, khachHang.getTen());
            statement.setString(3, khachHang.getDiaChi());
            statement.setString(4, khachHang.getSdt());
            statement.setString(5, khachHang.getEmail());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Cập nhật thông tin khách hàng
    public boolean updateKhachHang(KhachHangDTO khachHang) {
        String sql = "UPDATE khach_hang SET ten = ?, diaChi = ?, sdt = ?, email = ? WHERE maKH = ?";
        try (Connection connection = JdbcUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, khachHang.getTen());
            statement.setString(2, khachHang.getDiaChi());
            statement.setString(3, khachHang.getSdt());
            statement.setString(4, khachHang.getEmail());
            statement.setInt(5, khachHang.getMaKH());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Xóa khách hàng
    public boolean deleteKhachHang(int maKH) {
        String sql = "DELETE FROM khach_hang WHERE maKH = ?";
        try (Connection connection = JdbcUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, maKH);
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Lấy thông tin khách hàng theo mã
    public KhachHangDTO getKhachHangById(int maKH) {
        String sql = "SELECT * FROM khach_hang WHERE maKH = ?";
        try (Connection connection = JdbcUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, maKH);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return new KhachHangDTO(
                        resultSet.getInt("maKH"),
                        resultSet.getString("ten"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("sdt"),
                        resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy danh sách tất cả khách hàng
    public List<KhachHangDTO> getAllKhachHang() {
        List<KhachHangDTO> khachHangList = new ArrayList<>();
        String sql = "SELECT * FROM khach_hang";
        try (Connection connection = JdbcUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                KhachHangDTO khachHang = new KhachHangDTO(
                        resultSet.getInt("maKH"),
                        resultSet.getString("ten"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("sdt"),
                        resultSet.getString("email")
                );
                khachHangList.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHangList;
    }
}
