package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.entity.Order_Detail;
import com.warehouse.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired OrderDetailRepository orderDetailRepository;
	public ResponseEntity<List<Order_Detail>> findOrderDetails(int orderId) {

		return ResponseEntity.status(HttpStatus.OK).body(orderDetailRepository.findAllByOrderID(orderId));
	}
	public ResponseEntity add(Order_Detail orderDetail) {
		orderDetailRepository.save(orderDetail);
		return ResponseEntity.status(HttpStatus.OK).body("New detailOrder has been added");
	}
}
