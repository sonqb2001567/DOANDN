package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.UserService;
import com.example.demo.response.LoginResponse;

@RestController
@CrossOrigin(
origins = {"http://localhost:3000/login", 
		   "http://localhost:3000/register"},
allowCredentials = "true")
@RequestMapping("api/v1/user")
public class Usercontroller {
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDTO userDTO)
	{
		String id = userService.addUser(userDTO);
		System.out.println("Us");
		return id;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
	{
		LoginResponse loginResponse = userService.loginUser(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delUser(@PathVariable("id") int id)
	{
		String loginResponse = userService.deleteUser(id);
		return loginResponse;
	}
}
