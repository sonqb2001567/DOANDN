package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findOneByUsernameAndUserpassword(String userName, String userPassword);

	User findByUserpassword(String userpassword);

	User findByUsername(String username);
}
