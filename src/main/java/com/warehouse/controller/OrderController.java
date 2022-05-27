package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.DetailOrder_Display;
import com.warehouse.entity.Order;
import com.warehouse.entity.Order_Detail;
import com.warehouse.entity.Product;
import com.warehouse.entity.User;
import com.warehouse.service.OrderDetailService;
import com.warehouse.service.OrderService;
import com.warehouse.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired OrderService orderService;
	@Autowired OrderDetailService orderDetailService;
	
	@GetMapping("/export")
	public ResponseEntity<List<CustomOrder>> getAllExportOrders(){
		return orderService.findIEOrders("export");
	}
	@GetMapping("/import")
	public ResponseEntity<List<CustomOrder>> getAllImportOrders(){
		return orderService.findIEOrders("import");
	}
	@GetMapping("/register/product")
	public ResponseEntity<List<CustomProductDisplay>> getProduct(){
		return orderService.findAllProduct();
	}
	@GetMapping("/register/user")
	public ResponseEntity<List<User>> getUser(){
		return orderService.findAllUser();
	}
	@PostMapping
	public ResponseEntity addNewOrder(@RequestBody Order order ) {
		return orderService.add(order);
	}
	
	@GetMapping("/detail/{order_id}")
	public ResponseEntity<List<DetailOrder_Display>> getDetailOrder(@PathVariable int order_id){
		System.out.println(order_id);
		return orderDetailService.findOrderDetails(order_id);
	}
//	@PostMapping("/detail")
//	public ResponseEntity addNewDetailOrder(@RequestBody Order_Detail orderDetail ) {
//		return orderDetailService.add(orderDetail);
//	}

}
