package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.MoisDTO;
import com.example.demo.DTO.TempDTO;
import com.example.demo.Service.MoisService;
import com.example.demo.model.Mois;
import com.example.demo.repository.MoisRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/mois/")
public class MoisController {
	
	@Autowired
	private MoisRepository moisRepository;
	
	@Autowired
	private MoisService moisService;
	
	@GetMapping("/getAllMois")
	public List<Mois> getAllMois() {
		return moisRepository.findAll();
	}
	
	@GetMapping("/getAreaMois/{areaId}")
	public List<Mois> findAreaMois(@PathVariable Integer areaId) {
		return moisRepository.findTop7ByAreaidOrderByRectimeDesc(areaId);
	}
	
	@PostMapping("/postMois")
	public String saveMois(@RequestBody MoisDTO moisDTO)
	{
		return (moisService.addMois(moisDTO));
	}
}
