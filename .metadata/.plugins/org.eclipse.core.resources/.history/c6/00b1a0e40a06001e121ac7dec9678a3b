package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Temp;

@Repository
public interface TempRepository extends JpaRepository<Temp, Integer>{
	List<Temp> findByAreaid(Integer areaid);
}
