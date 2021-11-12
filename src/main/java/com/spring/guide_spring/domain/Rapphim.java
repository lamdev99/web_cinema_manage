package com.spring.guide_spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblRapphim")
public class Rapphim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String gioiThieu;
	private String ten;
	@OneToOne
    @JoinColumn(name = "diaChiId")
    private Diachi diachi;
	public Rapphim() {
		super();
	}
	
}
