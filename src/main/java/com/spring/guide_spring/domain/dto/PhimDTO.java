package com.spring.guide_spring.domain.dto;

public class PhimDTO implements Comparable<PhimDTO>{
	private int id;
	private String tenPhim;
	private int tongVeBanRa;
	private int tongDoanhThu;
	
	public PhimDTO(int id, String tenPhim, int tongVeBanRa, int tongDoanhThu) {
		super();
		this.id = id;
		this.tenPhim = tenPhim;
		this.tongVeBanRa = tongVeBanRa;
		this.tongDoanhThu = tongDoanhThu;
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
