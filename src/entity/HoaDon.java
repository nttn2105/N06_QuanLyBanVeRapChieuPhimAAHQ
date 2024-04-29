package entity;

import java.time.LocalDate;

public class HoaDon {
	private String MaHD;
	private double TongTien;
	private LocalDate NgayLHD;
	private String TenKH;
	private String SDT;
	private NhanVien nhanvien;
	
	public HoaDon(String maHD) {
		super();
		this.MaHD = maHD ;
		// TODO Auto-generated constructor stubs
	}
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public double getTongTien() {
		return TongTien;
	}
	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	public LocalDate getNgayLHD() {
		return NgayLHD;
	}
	public void setNgayLHD(LocalDate ngayLHD) {
		NgayLHD = ngayLHD;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public HoaDon(String maHD, double tongTien, LocalDate ngayLHD, String tenKH, String sDT, NhanVien nhanvien) {
		super();
		MaHD = maHD;
		TongTien = tongTien;
		NgayLHD = ngayLHD;
		TenKH = tenKH;
		SDT = sDT;
		this.nhanvien = nhanvien;
	}
	
}
