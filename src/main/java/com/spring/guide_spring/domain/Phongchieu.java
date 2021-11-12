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
@Table(name = "tblPhongchieu")
public class Phongchieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int soLuongGhe;
	private String dacDiem;
	private String tenPhongChieu;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rapPhimId", nullable = false)
    private Rapphim rapphim;
	public Phongchieu() {
		super();
	}
	
}
