package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.TempDTO;
import com.example.demo.model.Temp;
import com.example.demo.repository.TempRepository;

@Service
public class TempIMPL implements TempService{
	@Autowired
	private TempRepository tempRepository;
	
	@Override
	public String addTemp(TempDTO tempDTO) {
		Temp temp = new Temp(
				tempDTO.getAreaid(),
				tempDTO.getRectime(),
				tempDTO.getTemp()
				);
		System.out.println(tempDTO);
		tempRepository.save(temp);
		return ("Add success");
	}
	
}
