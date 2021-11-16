package com.spring.guide_spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.guide_spring.domain.Phim;
import com.spring.guide_spring.domain.dto.PhimDTO;
import com.spring.guide_spring.domain.dto.PhimDTOStatistics;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer>{
	@Query(nativeQuery = true,value = "select p.id as id,p.ten_phim as tenPhim,count(v.id) as tongVeBanRa,sum(s.gia_ve) as tongDoanhThu from tbl_phim as p inner join tbl_suatchieu as s on s.phim_id = p.id inner join tbl_ve as v on v.suat_chieu_id = s.id inner join tbl_hoadon as h on v.hoa_don_id = h.id where s.ngay_gio_chieu >= ?1 and s.ngay_gio_chieu <= ?2 group by p.id")
	List<PhimDTOStatistics> getTKDTTheoPhim(java.sql.Date start, java.sql.Date end);
	
	@Query(nativeQuery = true,value = "select p.id as id,p.ten_phim as tenPhim,count(v.id) as tongVeBanRa,sum(s.gia_ve) as tongDoanhThu from tbl_phim as p inner join tbl_suatchieu as s on s.phim_id = p.id inner join tbl_ve as v on v.suat_chieu_id = s.id inner join tbl_hoadon as h on v.hoa_don_id = h.id group by p.id")
	
	List<PhimDTOStatistics> getAllPhim();

}
