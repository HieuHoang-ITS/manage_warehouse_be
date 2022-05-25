package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.User;
import com.warehouse.service.UserService;

@RestController
@RequestMapping(path="api/v1/User")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("")
	public ResponseEntity<List> getAll(){
		return userService.getAllUser();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable int id) {
		return userService.getUser(id);
	}
	@PostMapping("/insert")
	public ResponseEntity insertUser(@RequestBody User newUser){
		
		return userService.insert(newUser);

	}
	@PutMapping("/{id}")

	public ResponseEntity updateUser(@RequestBody User u, @PathVariable int id) {
		return userService.update(u, id);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> Deletecategory(@PathVariable int id) {
		return userService.Delele(id);
		
				
	}
}
