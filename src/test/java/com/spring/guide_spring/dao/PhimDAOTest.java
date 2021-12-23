package com.spring.guide_spring.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.guide_spring.domain.dto.PhimDTO;
import com.spring.guide_spring.repository.PhimRepository;

@SpringBootTest
@Transactional
class PhimDAOTest {
	@Autowired
	PhimDAO phimDAO;
	@Autowired
	PhimRepository phimRepository;
	
	@Autowired
	PhimDAOTest(PhimDAO phimDAO,PhimRepository phimRepository){
		this.phimDAO = phimDAO;
		this.phimRepository = phimRepository;
	}
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
 
        @Bean
        public PhimDAO employeeService() {
            return new PhimDAO();
        }
    }
	
	@Test
	public void testGetTKDTTheoPhim(){
		try {
			Date start = new SimpleDateFormat("yyyy/MM/dd").parse("1997/01/01");
			Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2022/01/01");
			List<PhimDTO> list = phimDAO.getTKDTTheoPhim(start, end);
			assertNotEquals(list.size(),0);
		} catch (ParseException e) {
			
		}
		
	}
	/**
	 * Thoi gian bat dau nam trong 01/01/1997 - 31/12/2030
	 * Thoi gian ket thuc nam trong 01/01/1997 - 31/12/2030
	 * So ban ghi = 0
	 */
	@Test
	public void testGetTKDTTheoPhim1(){
		try {
			Date start = new SimpleDateFormat("yyyy/MM/dd").parse("1997/01/01");
			Date end = new SimpleDateFormat("yyyy/MM/dd").parse("1998/01/01");
			List<PhimDTO> list = phimDAO.getTKDTTheoPhim(start,end);
			assertEquals(list.size(), 0);
		} catch (ParseException e) {
			
		}
		
	}
	/**
	 * Thoi gian bat dau nam trong 01/01/1997 - 31/12/2030
	 * Thoi gian ket thuc: 31/12/2030
	 */
	@Test
	public void testGetTKDTTheoPhim2(){
		try {
			Date start = new SimpleDateFormat("yyyy/MM/dd").parse("2010/01/01");
			Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2030/01/01");
			List<PhimDTO> list = phimDAO.getTKDTTheoPhim(start,end);
			assertNotEquals(list.size(), 0);
		} catch (ParseException e) {
			
		}
		
	}
	/**
	 * Thoi gian bat dau : 01/01/1997
	 * Thoi gian ket thuc nam trong 01/01/1997 - 31/12/2030
	 */
	@Test
	public void testGetTKDTTheoPhim3(){
		try {
			Date start = new SimpleDateFormat("yyyy/MM/dd").parse("1997/01/01");
			Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2022/01/01");
			List<PhimDTO> list = phimDAO.getTKDTTheoPhim(start,end);
			assertNotEquals(list.size(), 0);
		} catch (ParseException e) {
			
		}
	}
	/**
	 * Thoi gian bat dau : 01/01/1997
	 * Thoi gian ket thuc nam trong 31/12/2030
	 */
	@Test
	public void testGetTKDTTheoPhim4(){
		try {
			Date start = new SimpleDateFormat("yyyy/MM/dd").parse("1997/01/01");
			Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2030/30/12");
			List<PhimDTO> list = phimDAO.getTKDTTheoPhim(start,end);
			assertNotEquals(list.size(), 0);
		} catch (ParseException e) {
			
		}
	}
}
