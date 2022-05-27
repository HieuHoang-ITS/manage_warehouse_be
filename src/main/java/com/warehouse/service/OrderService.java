package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.entity.Order;
import com.warehouse.entity.Thongke;
import com.warehouse.repository.OrderRepository;
@Service
public class OrderService {
	@Autowired OrderRepository orderRepository;
	public List<Thongke> th11()
	{
		return orderRepository.thongKeTheoThang();
	}
	
}
