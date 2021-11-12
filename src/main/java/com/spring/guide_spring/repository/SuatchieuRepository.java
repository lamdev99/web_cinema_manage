package com.spring.guide_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.guide_spring.domain.Suatchieu;
import com.spring.guide_spring.domain.dto.PhimDTO;
import com.spring.guide_spring.domain.dto.SuatchieuDTO;

@Repository
public interface SuatchieuRepository extends JpaRepository<Suatchieu, Integer>{
	@Query(
			  value = "SELECT * FROM USERS u WHERE u.status = 1", 
			  nativeQuery = true)
	SuatchieuDTO getDSSuatChieu(PhimDTO phim);
}
