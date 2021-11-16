package com.spring.guide_spring.domain.dto;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SuatchieuDTO implements Comparable<SuatchieuDTO>{
	private int id;
	private Date thoiGianChieu;	
	private String tenSuatChieu;
	private int soLuongVeBan;
	private int tongTienThu;
	private String tongTienThuVND;
	private String mThoiGianChieu;
	
	public SuatchieuDTO(int id,Date thoiGianChieu, String tenSuatChieu, int soLuongVeBan, int tongTienThu) {
		this.id = id;
		this.thoiGianChieu = thoiGianChieu;
		this.tenSuatChieu = tenSuatChieu;
		this.soLuongVeBan = soLuongVeBan;
		this.tongTienThu = tongTienThu;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		tongTienThuVND = formatter.format(tongTienThu);
		this.mThoiGianChieu = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(thoiGianChieu);
	}

	


	public String getTongTienThuVND() {
		return tongTienThuVND;
	}




	public void setTongTienThuVND(String tongTienThuVND) {
		this.tongTienThuVND = tongTienThuVND;
	}




	public String getmThoiGianChieu() {
		return mThoiGianChieu;
	}




	public void setmThoiGianChieu(String mThoiGianChieu) {
		this.mThoiGianChieu = mThoiGianChieu;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getThoiGianChieu() {
		return thoiGianChieu;
	}



	public void setThoiGianChieu(Date thoiGianChieu) {
		this.thoiGianChieu = thoiGianChieu;
	}



	public String getTenSuatChieu() {
		return tenSuatChieu;
	}



	public void setTenSuatChieu(String tenSuatChieu) {
		this.tenSuatChieu = tenSuatChieu;
	}



	public int getSoLuongVeBan() {
		return soLuongVeBan;
	}



	public void setSoLuongVeBan(int soLuongVeBan) {
		this.soLuongVeBan = soLuongVeBan;
	}



	public int getTongTienThu() {
		return tongTienThu;
	}



	public void setTongTienThu(int tongTienThu) {
		this.tongTienThu = tongTienThu;
	}



	@Override
	public int compareTo(SuatchieuDTO o) {
		return o.thoiGianChieu.compareTo(thoiGianChieu); 
	}
	
}
