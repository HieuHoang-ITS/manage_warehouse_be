package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.Order;
import com.warehouse.entity.Order_Detail;
import com.warehouse.entity.Product;
import com.warehouse.service.OrderDetailService;
import com.warehouse.service.OrderService;
import com.warehouse.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired OrderService orderService;
	@Autowired OrderDetailService orderDetailService;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders(){
		return orderService.findAllOrders();
	}
	@PostMapping
	public ResponseEntity addNewOrder(@RequestBody Order order ) {
		return orderService.add(order);
	}
	
	@GetMapping("/detail")
	public ResponseEntity<List<Order_Detail>> getDetailOrder(@RequestParam int order_id){
		System.out.println(order_id);
		return orderDetailService.findOrderDetails(order_id);
	}
	@PostMapping("/detail")
	public ResponseEntity addNewDetailOrder(@RequestBody Order_Detail orderDetail ) {
		return orderDetailService.add(orderDetail);
	}

}
