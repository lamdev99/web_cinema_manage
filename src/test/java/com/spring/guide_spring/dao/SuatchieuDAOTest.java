package com.spring.guide_spring.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.spring.guide_spring.domain.dto.PhimDTO;
import com.spring.guide_spring.domain.dto.SuatchieuDTO;
import com.spring.guide_spring.repository.SuatchieuRepository;

@SpringBootTest
@Transactional
class SuatchieuDAOTest {
	@Autowired
	SuatchieuDAO suatchieuDAO;
	@Autowired
	SuatchieuRepository suatchieuRepository;
	@Autowired
	public SuatchieuDAOTest(SuatchieuDAO suatchieuDAO, SuatchieuRepository suatchieuRepository) {
		// TODO Auto-generated constructor stub
		this.suatchieuDAO = suatchieuDAO;
		this.suatchieuRepository = suatchieuRepository;
	}
	/**
	 * 
	 */
	@Test
	void testGetDSSuatChieu() {
		try {
			Date start = new SimpleDateFormat("yyyy/MM/dd").parse("1997/01/01");
			Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2022/01/01");
			List<SuatchieuDTO> list = suatchieuDAO.getDSSuatChieu(start, end,1);
			assertNotEquals(list.size(),0);
		} catch (ParseException e) {
			
		}
	}
	@Test
	void testGetDSSuatChieu1() {
		try {
			Date start = new SimpleDateFormat("yyyy/MM/dd").parse("1997/01/01");
			Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2022/01/01");
			List<SuatchieuDTO> list = suatchieuDAO.getDSSuatChieu(start, end,2);
			assertNotEquals(list.size(),0);
		} catch (ParseException e) {
			
		}
	}

}
