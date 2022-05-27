package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.Order;
import com.warehouse.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired OrderRepository orderRepository;
	
	public ResponseEntity<List<CustomOrder>> findIEOrders(String type){
		List<CustomOrder> orders;	
		orders = orderRepository.findIEOrders(type);
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

	public ResponseEntity add(Order order) {
		orderRepository.save(order);
		return ResponseEntity.status(HttpStatus.OK).body("New Order has been added");
	}

}
