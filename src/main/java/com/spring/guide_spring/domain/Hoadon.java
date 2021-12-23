package com.spring.guide_spring.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblHoadon")
public class Hoadon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int tongTien;
	private int tienPhat;
	private int diemCong;
	private Date ngayMua;
	private String maSoThue;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "khachXemPhimId", nullable = false)
    private Khachxemphim khachxemphim;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nhanVienId", nullable = false)
    private Nhanvien nhanvien;
	public Hoadon() {
		super();
	}
	public Hoadon(int id, int tongTien, int tienPhat, int diemCong, Date ngayMua, String maSoThue) {
		super();
		this.id = id;
		this.tongTien = tongTien;
		this.tienPhat = tienPhat;
		this.diemCong = diemCong;
		this.ngayMua = ngayMua;
		this.maSoThue = maSoThue;
	}
	
}
