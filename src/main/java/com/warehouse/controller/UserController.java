package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.Category;
import com.warehouse.entity.User;
import com.warehouse.service.system.UserService;
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
	public ResponseEntity<List<User>> getAll(){
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
	@PutMapping("/update/{id}")

	public ResponseEntity updateUser(@RequestBody User u, @PathVariable int id) {
		return userService.update(u, id);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> Deletecategory(@PathVariable int id) {
		return userService.Delele(id);		
	}
	@GetMapping("/search")
	public ResponseEntity<List<User>>searchCategory(@RequestParam(required = false) String full_name,@RequestParam(required = false) String email,@RequestParam(required = false) String tel )
	{
		
		return userService.search(full_name, email, tel);
		
	}
}
