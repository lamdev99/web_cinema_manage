package com.spring.guide_spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblQuanly")
public class Quanly {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String boPhanQuanLy;
	@OneToOne
    @JoinColumn(name = "nguoiDungId")
    private Nguoidung nguoidung;
	public Quanly() {
		super();
	}
	
}
