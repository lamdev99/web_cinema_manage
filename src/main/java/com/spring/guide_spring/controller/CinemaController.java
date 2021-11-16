package com.spring.guide_spring.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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
import com.spring.guide_spring.dao.SuatchieuDAO;
import com.spring.guide_spring.domain.Nguoidung;
import com.spring.guide_spring.domain.Phim;
import com.spring.guide_spring.domain.dto.PhimDTO;
import com.spring.guide_spring.domain.dto.SuatchieuDTO;

@Controller
@RequestMapping("/cinema/")
public class CinemaController {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date start,end;
	
	@Autowired
	NguoiDungDAO nguoiDungDAO;
	@Autowired
	PhimDAO phimDAO;
	@Autowired
	SuatchieuDAO suatchieuDAO;

	
	
	public CinemaController() {
		super();
		String timeTestStart = "1997-01-01 00:00:00";
		String timeTestEnd = "2030-12-31 00:00:00";
		try {
			start = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(timeTestStart);
			end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(timeTestEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("404")
	public String show404() {
		return "404";
	}

	@GetMapping("index")
	public String showIndex() {
		return "gdChinhQL";
	}

	@GetMapping("dashboards/{id}")
	public String showDetails(@PathVariable int id, Model model) {
		
		List<SuatchieuDTO> suatchieus = suatchieuDAO.getDSSuatChieu(start, end, id);
		Phim phim = phimDAO.getPhimById(id);
		
		int tongDoanhThu = 0,tongVeBanRa = 0;
		for(SuatchieuDTO suatchieuDTO : suatchieus) {
			tongDoanhThu += suatchieuDTO.getTongTienThu();
			tongVeBanRa += suatchieuDTO.getSoLuongVeBan();
		}
		PhimDTO phimDTO = new PhimDTO(phim.getTenPhim(),tongVeBanRa,tongDoanhThu);
		model.addAttribute("phimDTO",phimDTO);
		model.addAttribute("suatchieus", suatchieus);
		return "gdChiTietPhim";
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
			return "gdTKDTTheoPhim";
		}
		this.start = start;
		this.end = end;
		List<PhimDTO> list = phimDAO.getTKDTTheoPhim(start, end);
		model.addAttribute("phims", list);
		try {
			model.addAttribute("start",new SimpleDateFormat("dd/MM/yyyy").parse("22/10/2021"));
			model.addAttribute("end",new SimpleDateFormat("dd/MM/yyyy").parse("22/10/2021"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "gdTKDTTheoPhim";
	}
	
	@GetMapping("statistic")
	public String showStatistic() {
		return "gdThongKe";
	}
}
