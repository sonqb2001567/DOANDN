package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.TempDTO;
import com.example.demo.Service.TempService;
import com.example.demo.model.Temp;
import com.example.demo.repository.TempRepository;
import com.example.demo.response.LoginResponse;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/temp/")
public class TempController {
	
	@Autowired
	private TempRepository tempRepository;
	
	@Autowired
	private TempService tempService;
	
	@GetMapping("/getAllTemps")
	public List<Temp> getAllTemps() {
		return tempRepository.findAll();
	}
	
	@GetMapping("/getAreaTemp/{areaId}")
	public List<Temp> findAreaTemp(@PathVariable Integer areaId) {
		return tempRepository.findByAreaid(areaId);
	}
	
	@PostMapping("/postTemp")
	public String saveTemp(@RequestBody TempDTO tempDTO)
	{
		return (tempService.addTemp(tempDTO));
	}
	
}
