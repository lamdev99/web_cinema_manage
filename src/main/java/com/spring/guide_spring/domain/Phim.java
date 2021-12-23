package com.spring.guide_spring.domain;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblPhim")
public class Phim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenPhim;
	private String loaiPhim;
	private Date namSanXuat;
	private String moTa;

//	@Transient
	public Phim() {
		super();
	}

	public Phim(int id, String tenPhim, String loaiPhim, Date namSanXuat, String moTa) {
		super();
		this.id = id;
		this.tenPhim = tenPhim;
		this.loaiPhim = loaiPhim;
		this.namSanXuat = namSanXuat;
		this.moTa = moTa;
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

	public String getLoaiPhim() {
		return loaiPhim;
	}

	public void setLoaiPhim(String loaiPhim) {
		this.loaiPhim = loaiPhim;
	}

	public Date getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(Date namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
