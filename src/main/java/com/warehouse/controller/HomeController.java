package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.HomeDisplay;
import com.warehouse.repository.HomeRepository;
import com.warehouse.service.HomeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/home")
public class HomeController {
	@Autowired HomeService homeService;
	@Autowired HomeRepository homeRepository;
	@GetMapping
	public ResponseEntity<List<CustomOrder>> getAllImportOrders(){
		return homeService.findAllOrders();
	}
	@GetMapping("/total")
	public ResponseEntity<HomeDisplay> getAllTotals(){
		return homeService.getAllTotals();
	}
}
