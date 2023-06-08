package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.AreaRepository;
import com.example.demo.model.Area;

@RestController
@RequestMapping("/api/area/")
public class AreaController {
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/getAll")
	public List<Area> findAllArea() {
		return areaRepository.findAll();
	}
}
