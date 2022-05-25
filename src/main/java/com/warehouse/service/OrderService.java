package com.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.entity.Order;
import com.warehouse.repository.OrderRepository;

@Service
public class OrderService {
 @Autowired
 OrderRepository orderRepository;
 public List<Order> getAllOrderStatus(String status)
 {
	 return orderRepository.getALLOrderStatus(status);
 }
 public Optional<Order> getorderbyId(int id)
 {
	return orderRepository.findById(id);
 }
 public void insertOrUpdate(Order order)
 {
	 orderRepository.save(order);
 }
}
