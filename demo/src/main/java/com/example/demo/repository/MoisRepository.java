package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Mois;
import com.example.demo.model.Temp;


@Repository
public interface MoisRepository extends JpaRepository<Mois, Integer>{
	List<Mois> findByAreaid(Integer areaid);
	List<Mois> findTop7ByAreaidOrderByRectimeDesc(Integer areaid);
}
