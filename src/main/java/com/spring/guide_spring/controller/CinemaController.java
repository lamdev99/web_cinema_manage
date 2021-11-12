package com.spring.guide_spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.guide_spring.dao.NguoiDungDAO;
import com.spring.guide_spring.dao.PhimDAO;
import com.spring.guide_spring.domain.Nguoidung;
import com.spring.guide_spring.domain.dto.PhimDTO;

@Controller
@RequestMapping("/cinema/")
public class CinemaController {

	@Autowired
	NguoiDungDAO nguoiDungDAO;
	@Autowired
	PhimDAO phimDAO;

	@GetMapping("404")
	public String show404() {
		return "404";
	}

	@GetMapping("index")
	public String showIndex() {
		return "index";
	}

	@GetMapping("dashboards/{id}")
	public String showDetails(@PathVariable int id, Model model) {
		PhimDTO phim = (new PhimDTO(1, "Viet Nam", 123, 123456));
		model.addAttribute("phim", phim);
		return "details";
	}

	@GetMapping("register")
	public String showRegister() {
		return "register";
	}

	@GetMapping("login")
	public String showLogin(Nguoidung nguoidung) {
		return "login";
	}

	@PostMapping("login")
	public String checkLogin(@Valid Nguoidung nguoidung, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "404";
		}
		Nguoidung nguoidung1 = nguoiDungDAO.checkLogin(nguoidung.getTenDangNhap(), nguoidung.getMatKhau());
		if (nguoidung1 == null) {
			return "404";
		}
		return "redirect:index";
	}

	@GetMapping("home")
	public String showHome() {
		return "index";
	}

	@GetMapping("dashboards")
	public String showDashboardSearch(Model model,
			@RequestParam(name = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
			@RequestParam(name = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {

		if (start == null && end == null) {
			List<PhimDTO> list = phimDAO.getAllPhim();
			model.addAttribute("phims", list);
			return "tables";
		}

		List<PhimDTO> list = phimDAO.getTKDTTheoPhim(start, end);
		model.addAttribute("phims", list);
		model.addAttribute("start","22/10/2021");
		model.addAttribute("end","22/10/2021");
		return "tables";
	}
}
