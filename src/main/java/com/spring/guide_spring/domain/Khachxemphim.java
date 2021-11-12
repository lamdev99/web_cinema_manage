package com.spring.guide_spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblKhachxemphim")
public class Khachxemphim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int tuoi;
	private String gioiTinh;
	public Khachxemphim() {
		super();
	}
	
}
