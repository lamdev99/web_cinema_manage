package com.spring.guide_spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblNguoidung")
public class Nguoidung {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	private String matKhau;
	private String tenDangNhap;
	private String soDienThoai;
	@OneToOne
    @JoinColumn(name = "diaId")
    private Diachi diaChi;
	@OneToOne
    @JoinColumn(name = "hoTenId")
    private Hoten hoten ;
	
	public Nguoidung() {
		super();
	}
	public Nguoidung(String matKhau, String tenDangNhap) {
		super();
		this.matKhau = matKhau;
		this.tenDangNhap = tenDangNhap;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Diachi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(Diachi diaChi) {
		this.diaChi = diaChi;
	}
	public Hoten getHoten() {
		return hoten;
	}
	public void setHoten(Hoten hoten) {
		this.hoten = hoten;
	}
	
}
