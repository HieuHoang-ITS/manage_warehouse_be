package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.entity.DetailOrder_Display;
import com.warehouse.entity.Order_Detail;
import com.warehouse.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired OrderDetailRepository orderDetailRepository;
//	@Autowired CustomOrderDetailRepository cOrderDetailRepository;
	public ResponseEntity<List<DetailOrder_Display>> findOrderDetails(int order_id) {
//		return null;
		return ResponseEntity.status(HttpStatus.OK).body(orderDetailRepository.findAllOrderID(order_id));
	}
//	public ResponseEntity add(Order_Detail orderDetail) {
//		orderDetailRepository.save(orderDetail);
//		return ResponseEntity.status(HttpStatus.OK).body("New detailOrder has been added");
//	}
}
