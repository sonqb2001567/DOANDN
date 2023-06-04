package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.LoginResponse;

@Service
public class UserIMPL implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addUser(UserDTO userDTO) {
		User user = new User(
				userDTO.getFullname(),
				userDTO.getUsername(),
				this.passwordEncoder.encode(userDTO.getUserpassword())
				);
		System.out.println("S");
		User tempUser = userRepository.findByUsername(userDTO.getUsername());
		if (tempUser == null) {
			System.out.println("SUP");
			userRepository.save(user);
			return user.getFullname();
		}
		else {
			System.out.println("YO");
			return "User exist";
		}
	}

	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {
		String msg = "";
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if (user != null) {
            String password = loginDTO.getUserpassword();
            String encodedPassword = user.getUserpassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> userr = userRepository.findOneByUsernameAndUserpassword(loginDTO.getUsername(), encodedPassword);
                if (userr.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
 
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("user not exits", false);
        }
	}

	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "delete user " + id;
	}

}
