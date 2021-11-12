package com.spring.guide_spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblMathang")
public class Mathang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ten;
	private int giaBan;
	private int soLuongCon;
	private String moTa;
	public Mathang() {
		super();
	}
	
}
