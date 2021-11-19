package com.spring.guide_spring.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.guide_spring.dao.NguoiDungDAO;

@RunWith(SpringRunner.class)
@WebMvcTest(CinemaController.class)
class CinemaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NguoiDungDAO nguoiDungDAO;
	
	@Test
	void test() {
	}

	@Test 
	void callAPI() {

	}
}
