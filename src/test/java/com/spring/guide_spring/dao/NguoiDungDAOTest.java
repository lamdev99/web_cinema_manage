package com.spring.guide_spring.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.guide_spring.domain.Nguoidung;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NguoiDungDAOTest {

	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
 
        @Bean
        public DAO employeeService() {
            return new NguoiDungDAO();
        }
    }
	
	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Before
	public void setUp() {
		Nguoidung nguoidung = new Nguoidung("admin1","YWRtaW4x");
		testEntityManager.persist(nguoidung);
		testEntityManager.flush();
	}
	/**
	 * Ten dang nhap: ton tai
	 * Mat khau: ton tai
	 */
	@Test
	@DisplayName("Test login success")
	public void testDangNhapThanhCong() {
		Nguoidung nguoidung = new Nguoidung("admin1","YWRtaW4x");
		Nguoidung nguoidungFound = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		assertNotEquals(nguoidungFound,null);
	}
	/**
	 * Ten dang nhap: ton tai
	 * Mat khau: sai
	 */
	@Test
	public void testDangNhapKhongThanhCong() {
		Nguoidung nguoidung = new Nguoidung("admin1","YWRtaW4y");
		
		Nguoidung nguoidungFound = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		assertEquals(nguoidungFound,null);
	}

	/**
	 * Ten dang nhap: ton tai
	 * Mat khau: sai
	 */
	@Test
	public void testDangNhapKhongThanhCong1() {
		Nguoidung nguoidung = new Nguoidung("admin1","123");
		
		Nguoidung nguoidungFound = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		assertEquals(nguoidungFound,null);
	}

	/**
	 * Ten dang nhap: ton tai
	 * Mat khau: sai
	 */
	@Test
	public void testDangNhapKhongThanhCong2() {
		Nguoidung nguoidung = new Nguoidung("lamnguyen","YWRtaW4y");
		
		Nguoidung nguoidungFound = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		assertEquals(nguoidungFound,null);
	}
	/**
	 * Ten dang nhap: ton tai
	 * Mat khau: sai
	 */
	@Test
	public void testDangNhapKhongThanhCong3() {
		Nguoidung nguoidung = new Nguoidung("","YWRtaW4y");
		
		Nguoidung nguoidungFound = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		assertEquals(nguoidungFound,null);
	}
	/**
	 * Ten dang nhap: ton tai
	 * Mat khau: sai
	 */
	@Test
	public void testDangNhapKhongThanhCong4() {
		Nguoidung nguoidung = new Nguoidung("admin1","");
		
		Nguoidung nguoidungFound = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		assertEquals(nguoidungFound,null);
	}
	/**
	 * Ten dang nhap: ton tai
	 * Mat khau: sai
	 */
	@Test
	public void testDangNhapKhongThanhCong5() {
		Nguoidung nguoidung = new Nguoidung("$$%$#@#@","YWRtaW4y");
		
		Nguoidung nguoidungFound = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		assertEquals(nguoidungFound,null);
	}
	/**
	 * Ten dang nhap: ton tai
	 * Mat khau: sai
	 */
	@Test
	public void testDangNhapKhongThanhCong6() {
		Nguoidung nguoidung = new Nguoidung("admin1 OR 1=1","YWRtaW4y");
		
		Nguoidung nguoidungFound = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		assertEquals(nguoidungFound,null);
	}
	
}
