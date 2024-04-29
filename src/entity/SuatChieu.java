package entity;

import java.time.LocalDateTime;

public class SuatChieu {
	private String maSuatChieu;
	private LocalDateTime timeBD;
	private LocalDateTime timeKT;
	private Phim mphim;
	private Phong mPhong;
	public String getMaSuatChieu() {
		return maSuatChieu;
	}
	public void setMaSuatChieu(String maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}
	public LocalDateTime getTimeBD() {
		return timeBD;
	}
	public void setTimeBD(LocalDateTime timeBD) {
		this.timeBD = timeBD;
	}
	public LocalDateTime getTimeKT() {
		return timeKT;
	}
	public void setTimeKT(LocalDateTime timeKT) {
		this.timeKT = timeKT;
	}
	public Phim getMphim() {
		return mphim;
	}
	public void setMphim(Phim mphim) {
		this.mphim = mphim;
	}
	public Phong getmPhong() {
		return mPhong;
	}
	public void setmPhong(Phong mPhong) {
		this.mPhong = mPhong;
	}
	public SuatChieu() {
		// TODO Auto-generated constructor stub
	}
	public SuatChieu(String maSuatChieu, LocalDateTime timeBD, LocalDateTime timeKT, Phim mphim, Phong mPhong) {
		super();
		this.maSuatChieu = maSuatChieu;
		this.timeBD = timeBD;
		this.timeKT = timeKT;
		this.mphim = mphim;
		this.mPhong = mPhong;
	}
	
}
