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

import com.example.demo.DTO.DeviceDTO;
import com.example.demo.Service.DeviceService;
import com.example.demo.model.Devices;
import com.example.demo.repository.DevicesRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/devices/")
public class DevicesController {
	
	@Autowired
	private DevicesRepository devicesRepository;
	
	@Autowired
	private DeviceService deviceService;
	
	@GetMapping("/getAreaDevices/{areaID}")
	public List<Devices> findAreaDevices(@PathVariable Integer areaID ) {
		return devicesRepository.findByAreaid(areaID);
		
	}
	
	@PostMapping("/save")
	public String saveDevice(@RequestBody DeviceDTO deviceDTO) {
		System.out.println("L");
		return deviceService.addDevice(deviceDTO);
		
	}
}
