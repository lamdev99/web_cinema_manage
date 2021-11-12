package com.spring.guide_spring.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.guide_spring.domain.Nguoidung;
import com.spring.guide_spring.repository.NguoidungRepository;

@Service
public class NguoiDungDAO implements DAO<Nguoidung>{

	@Autowired
	NguoidungRepository nguoidungRepository;
	@Override
	public Optional<Nguoidung> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Nguoidung> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public Nguoidung checkLogin(String username, String password) {
		return nguoidungRepository.checkLogin(username, password);
	}

}
