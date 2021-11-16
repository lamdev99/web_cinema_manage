package com.spring.guide_spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.guide_spring.domain.dto.SuatchieuDTO;
import com.spring.guide_spring.domain.dto.SuatchieuDTOStatistics;
import com.spring.guide_spring.repository.SuatchieuRepository;

@Service
public class SuatchieuDAO implements DAO<SuatchieuDTO>{

	@Autowired
	SuatchieuRepository suatchieuRepository;
	
	@Override
	public Optional<SuatchieuDTO> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<SuatchieuDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<SuatchieuDTO> getDSSuatChieu(Date start, Date end,int id){
		List<SuatchieuDTOStatistics> listDTOStatisticss = suatchieuRepository.getDSSuatChieu(new java.sql.Date(start.getTime()), new java.sql.Date(end.getTime()), id);
		List<SuatchieuDTO> list = new ArrayList<>();
		for(SuatchieuDTOStatistics s : listDTOStatisticss) {
			list.add(new SuatchieuDTO(s.getId(),s.getThoiGianChieu(), s.getTenSuatChieu(),s.getSoLuongVeBan(), s.getTongTienThu()));
		}
		return list;
	}
}
