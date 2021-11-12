package com.spring.guide_spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblThethanthiet")
public class Thethanthiet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int diemTichLuy;
	private String cccd;
	@OneToOne
    @JoinColumn(name = "hoTenId")
    private Hoten hoten;
	@OneToOne
    @JoinColumn(name = "khachXemPhimId")
    private Khachxemphim khachxemphim;
	public Thethanthiet() {
		super();
	}
	
}
