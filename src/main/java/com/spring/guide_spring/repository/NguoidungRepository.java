package com.spring.guide_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.guide_spring.domain.Nguoidung;

@Repository
public interface NguoidungRepository extends JpaRepository<Nguoidung, Integer>{
	@Query(
			  value = "SELECT * FROM tbl_nguoidung WHERE mat_khau = ?2 and ten_dang_nhap = ?1", 
			  nativeQuery = true)
	Nguoidung checkLogin(String username, String password);
}
