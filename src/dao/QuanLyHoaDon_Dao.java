package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import connectDB.Database;
import entity.HoaDon;
import entity.NhanVien;

public class QuanLyHoaDon_Dao {
	private ArrayList<HoaDon> dshd;
	public QuanLyHoaDon_Dao() {
		dshd = new ArrayList<HoaDon>();
	}
	public ArrayList<HoaDon> doctuBang()
	{
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "SELECT * FROM HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
            	String maHD = rs.getString("MAHOADON"); 
            	Double tongtien = rs.getDouble("TONGTIEN");
            	LocalDate ngayLHD = rs.getDate("NGAYLAPHOADON").toLocalDate();
            	String tenKH = rs.getString("TENKHACHHANG");
            	String sdt = rs.getString("SODIENTHOAI");
            	NhanVien nv = new NhanVien(rs.getString("MANHANVIEN"));
            	HoaDon hd = new HoaDon(maHD, tongtien, ngayLHD, tenKH, sdt, nv);
            	dshd.add(hd);
            }
		} catch (SQLException e) {	
			e.printStackTrace();
			// TODO: handle exception
		}
		return dshd;
		
	}
	
	public ArrayList<HoaDon> timKiemTheoTenKhachHang(String tenKhachHang) {
		doctuBang();
		ArrayList<HoaDon> DSKH;
		DSKH = new ArrayList<HoaDon>();
	    for (HoaDon hd : dshd) {
	        if (hd.getTenKH().contains(tenKhachHang)) {
	        	DSKH.add(hd);
	        }
	    }
	    return DSKH;
	}
	public ArrayList<HoaDon> timkiemtheoNgay(LocalDate ngay)
	{
		ArrayList<HoaDon> DSN;
		DSN = new ArrayList<HoaDon>();
		doctuBang();
		for(HoaDon hd : dshd)
		{
			if(hd.getNgayLHD().equals(ngay))
			{
				DSN.add(hd);
			}
		}
		return DSN;
	}
	
	public ArrayList<Object[]> layChiTietHoaDon(String maHD) {
        ArrayList<Object[]> chiTietHoaDonList = new ArrayList<>();
        String sql = "SELECT CHITIETHOADON.MAVE, CHITIETHOADON.MAHOADON, CHITIETHOADON.GIAVE " +
                     "FROM CHITIETHOADON " +
                     "WHERE CHITIETHOADON.MAHOADON = ?";
        try (Connection con = Database.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] rowData = {
                        rs.getString("MAVE"),
                        rs.getString("MAHOADON"),
                        rs.getDouble("GIAVE")
                };
                chiTietHoaDonList.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietHoaDonList;
    }
}
