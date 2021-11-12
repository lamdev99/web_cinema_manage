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
@Table(name = "tblMathangduocban")
public class Mathangduocban {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int donGia;
	private int soLuong;
	private int uuDai;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "matHangId", nullable = false)
    private Mathang mathang;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hoaDonId", nullable = false)
    private Hoadon hoadon;
	public Mathangduocban() {
		super();
	}
	
}
