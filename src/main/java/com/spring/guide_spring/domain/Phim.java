package com.spring.guide_spring.domain;

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
	public Phim() {
		super();
	}
	
}
