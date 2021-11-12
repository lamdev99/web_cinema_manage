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
@Table(name = "tblVe")
public class Ve {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int trangThai;
	private int uuDai;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gheId", nullable = false)
    private Ghe ghe;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "suatChieuId", nullable = false)
    private Suatchieu suatchieu;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hoaDonId", nullable = false)
    private Hoadon hoadon;
	public Ve() {
		super();
	}
	
}
