package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.entity.User;
import com.warehouse.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private final UserRepository ur;
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	public ResponseEntity<List<User>> getAllUser() {
		// TODO Auto-generated method stub
		
		return ResponseEntity.status(HttpStatus.OK).body(ur.findAll());
		
		
}
	public ResponseEntity insert(User user){
		ur.save(user);
	return ResponseEntity.status(HttpStatus.OK).body("Inser user successfully");
}
	public ResponseEntity update(User u, int id) {
		// TODO Auto-generated method stub
		User newuser = ur.findById(id).map(user -> {
			user.setFull_name(u.getFull_name());
			user.setEmail(u.getEmail());
			user.setTel(u.getTel());
			user.setAddress(u.getAddress());
			return ur.save(user);
		}).orElseGet(() -> {
			u.setId(id);
			return ur.save(u);

		});
		return ResponseEntity.status(HttpStatus.OK).body("update successfully");	
		}
	
	public ResponseEntity getUser(int id) {

		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.OK).body(ur.findById(id));
	}
	public ResponseEntity Delele(int id) {
		boolean exists = ur.existsById(id);
		if (exists) {
			ur.deleteById(id);
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
		return new ResponseEntity<String>("NOT_FOUND",HttpStatus.NOT_FOUND);
	}
	
	
}
