package com.spring.guide_spring.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "tblGhe")
public class Ghe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hang;
	private int cot;
	private String ghiChu;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "phongChieuId", nullable = false)
    private Phongchieu phongchieu;
	public Ghe() {
		super();
	}
	
}
