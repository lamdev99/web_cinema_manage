package com.spring.guide_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.guide_spring.domain.Suatchieu;
import com.spring.guide_spring.domain.dto.SuatchieuDTOStatistics;

@Repository
public interface SuatchieuRepository extends JpaRepository<Suatchieu, Integer>{
	@Query(
			  value = "select s.id as id,p.ten_phim as tenSuatChieu,s.ngay_gio_chieu as thoiGianChieu,count(v.id) as soLuongVeBan,sum(s.gia_ve) as tongTienThu from tbl_phim as p inner join tbl_suatchieu as s on s.phim_id = p.id inner join tbl_ve as v on v.suat_chieu_id = s.id inner join tbl_hoadon as h on v.hoa_don_id = h.id where s.ngay_gio_chieu >= ?1 and s.ngay_gio_chieu <= ?2 and p.id = ?3 group by s.id", 
			  nativeQuery = true)
	List<SuatchieuDTOStatistics> getDSSuatChieu(java.sql.Date start, java.sql.Date end,int idPhim);
}
