package com.spring.guide_spring.domain.dto;

import java.text.DecimalFormat;

public class PhimDTO implements Comparable<PhimDTO>{
	private int id;
	private String tenPhim;
	private int tongVeBanRa;
	private int tongDoanhThu;
	private String tongDoanhThuVND;
	
	
	
	public PhimDTO(String tenPhim, int tongVeBanRa, int tongDoanhThu) {
		super();
		this.tenPhim = tenPhim;
		this.tongVeBanRa = tongVeBanRa;
		this.tongDoanhThu = tongDoanhThu;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		tongDoanhThuVND = formatter.format(tongDoanhThu);
	}

	public PhimDTO() {
		super();
	}

	public PhimDTO(int id, String tenPhim, int tongVeBanRa, int tongDoanhThu) {
		super();
		this.id = id;
		this.tenPhim = tenPhim;
		this.tongVeBanRa = tongVeBanRa;
		this.tongDoanhThu = tongDoanhThu;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		tongDoanhThuVND = formatter.format(tongDoanhThu);
	}
	
	public String getTongDoanhThuVND() {
		return tongDoanhThuVND;
	}

	public void setTongDoanhThuVND(String tongDoanhThuVND) {
		this.tongDoanhThuVND = tongDoanhThuVND;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public int getTongVeBanRa() {
		return tongVeBanRa;
	}

	public void setTongVeBanRa(int tongVeBanRa) {
		this.tongVeBanRa = tongVeBanRa;
	}

	public int getTongDoanhThu() {
		return tongDoanhThu;
	}

	public void setTongDoanhThu(int tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}

	@Override
	public int compareTo(PhimDTO o) {
		return o.tongDoanhThu - tongDoanhThu;
	}
	
}
