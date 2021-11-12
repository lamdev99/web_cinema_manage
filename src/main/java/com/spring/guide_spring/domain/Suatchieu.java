package com.spring.guide_spring.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblSuatchieu")
public class Suatchieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date ngayGioChieu;
	private int giaVe;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "phongChieuId", nullable = false)
    private Phongchieu phongchieu;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "phimId", nullable = false)
    private Phim phim;
	public Suatchieu() {
		super();
	}
	
}
