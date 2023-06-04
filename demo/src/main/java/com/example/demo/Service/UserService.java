package com.example.demo.Service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.response.LoginResponse;

public interface UserService {

	String addUser(UserDTO userDTO);

	LoginResponse loginUser(LoginDTO loginDTO);
	
	String deleteUser(int id);
}
