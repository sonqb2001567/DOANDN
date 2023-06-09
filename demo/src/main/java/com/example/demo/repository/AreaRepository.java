package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{

	Area findByAreaname(String areaname);

	@Modifying
    @Query("UPDATE Area e SET e.areaname = :newValue WHERE e.id = :id")
	void updateAreanameById(Integer id, String newValue);
}
