package com.spring.guide_spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblDiachi")
public class Diachi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String soNha;
	private String quan;
	private String thanhPho;
	
	public Diachi() {
		super();
	}
	public Diachi(int id, String soNha, String quan, String thanhPho) {
		super();
		this.id = id;
		this.soNha = soNha;
		this.quan = quan;
		this.thanhPho = thanhPho;
	}
	public String getSoNha() {
		return soNha;
	}
	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public String getThanhPho() {
		return thanhPho;
	}
	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}
	

}
