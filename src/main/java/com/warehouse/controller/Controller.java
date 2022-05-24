package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.Order;
import com.warehouse.entity.Order_Detail;
import com.warehouse.service.OrderDetailService;
import com.warehouse.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired OrderService orderService;
	@Autowired OrderDetailService orderDetailService; 
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders(){
		return orderService.findAllOrders();
	}
	@PutMapping
	public ResponseEntity<List<Order_Detail>> addOrder(@RequestParam int orderId){
		return orderDetailService.findOrderDetails(orderId);
	}

}
