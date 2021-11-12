package com.spring.guide_spring.domain.dto;

import java.util.Date;

public class SuatchieuDTO implements Comparable<SuatchieuDTO>{
	private int id;
	private Date thoiGianChieu;	
	private String tenSuatChieu;
	private int soLuongVeBan;
	private int tongTienThu;
	
	
	
	public SuatchieuDTO(Date thoiGianChieu, String tenSuatChieu, int soLuongVeBan, int tongTienThu) {
		super();
		this.thoiGianChieu = thoiGianChieu;
		this.tenSuatChieu = tenSuatChieu;
		this.soLuongVeBan = soLuongVeBan;
		this.tongTienThu = tongTienThu;
	}



	@Override
	public int compareTo(SuatchieuDTO o) {
		return o.thoiGianChieu.compareTo(thoiGianChieu); 
	}
	
}
