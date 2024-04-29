package entity;

public class Phong {
	private String maPhong;
	private int soLuong;
	private String thongtinPhongchieu;
	public Phong() {
		// TODO Auto-generated constructor stub
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getThongtinPhongchieu() {
		return thongtinPhongchieu;
	}
	public void setThongtinPhongchieu(String thongtinPhongchieu) {
		this.thongtinPhongchieu = thongtinPhongchieu;
	}
	public Phong(String maPhong, int soLuong, String thongtinPhongchieu) {
		super();
		this.maPhong = maPhong;
		this.soLuong = soLuong;
		this.thongtinPhongchieu = thongtinPhongchieu;
	}
	
}
