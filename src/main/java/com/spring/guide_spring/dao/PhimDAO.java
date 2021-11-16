package com.spring.guide_spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.guide_spring.domain.Phim;
import com.spring.guide_spring.domain.dto.PhimDTO;
import com.spring.guide_spring.domain.dto.PhimDTOStatistics;
import com.spring.guide_spring.repository.PhimRepository;

@Service
public class PhimDAO implements DAO<Phim>{
	
	@Autowired
	PhimRepository phimRepository;
	
	@Override
	public Optional<Phim> get(int id) {
		
		return null;
	}

	@Override
	public Collection<Phim> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Phim getPhimById(int id) {
		return phimRepository.findById(id).orElse(null);
	}
	
	public List<PhimDTO> getTKDTTheoPhim(Date start, Date end){
		List<PhimDTOStatistics> listDTDtoStatistics = phimRepository.getTKDTTheoPhim(new java.sql.Date(start.getTime()), new java.sql.Date(end.getTime()));
		List<PhimDTO> list = new ArrayList<>();
		for(PhimDTOStatistics p : listDTDtoStatistics) {
			list.add(new PhimDTO(p.getId(), p.getTenPhim(), p.getTongVeBanRa(), p.getTongDoanhThu()));
		}
		return list;
	}
	public List<PhimDTO> getAllPhim(){
		List<PhimDTOStatistics> listDTDtoStatistics = phimRepository.getAllPhim();
		List<PhimDTO> list = new ArrayList<>();
		for(PhimDTOStatistics p : listDTDtoStatistics) {
			list.add(new PhimDTO(p.getId(), p.getTenPhim(), p.getTongVeBanRa(), p.getTongDoanhThu()));
		}
		return list;
	}

}
