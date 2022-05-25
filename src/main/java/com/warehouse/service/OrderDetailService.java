package com.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.entity.Order_Detail;
import com.warehouse.repository.OrderDetailRepository;
import com.warehouse.repository.OrderRepository;

@Service
public class OrderDetailService {
	@Autowired
	OrderDetailRepository orderDetailReposiory;
	
	public Optional<Order_Detail>  getbyid(int id)
	{
		return orderDetailReposiory.findById(id);
	}
	public Optional<List<Order_Detail>> getOrderDetailbyOrder(int order_id)
	{
		return Optional.of(orderDetailReposiory.getOrderDetailbyOrder(order_id));
	}
}
