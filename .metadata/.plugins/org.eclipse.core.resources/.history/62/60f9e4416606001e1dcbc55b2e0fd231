package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Devices;

@Repository
public interface DevicesRepository extends JpaRepository<Devices, Integer> {
	List<Devices> findByAreaid(Integer areaid);
}
