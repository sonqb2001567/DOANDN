package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.MoisDTO;
import com.example.demo.DTO.TempDTO;
import com.example.demo.model.Mois;
import com.example.demo.model.Temp;
import com.example.demo.repository.MoisRepository;
import com.example.demo.repository.TempRepository;

@Service
public class MoisIMPL implements MoisService{
	@Autowired
	private MoisRepository moisRepository;
	
	@Override
	public String addMois(MoisDTO moisDTO) {
		Mois mois = new Mois(
				moisDTO.getAreaid(),
				moisDTO.getRectime(),
				moisDTO.getMois()
				);
		System.out.println(moisDTO);
		moisRepository.save(mois);
		return ("Add success");
	}
	
}
