package com.crudtest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudtest.entity.User;
import com.crudtest.repository.UserRepository;

@RestController
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("admin")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("user/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userRepo.findById(id);
	}
	
	@GetMapping("users")
	public List<User> getAllUsers() {
		List<User> list = userRepo.findAll();
		return list;
	}
	
	@PostMapping("user")
	public void addUser(@RequestBody User user) {
		if(user != null)
			userRepo.save(user);
	}
	
	@PutMapping
	public void updateUser(@RequestBody User user) {
		if(user != null)
			userRepo.save(user);
	}
	
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepo.delete(userRepo.getOne(id));
	}
	
}
