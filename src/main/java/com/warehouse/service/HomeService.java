package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.entity.CustomOrder;
import com.warehouse.repository.HomeRepository;
import com.warehouse.entity.HomeDisplay;

@Service
public class HomeService {
	@Autowired HomeRepository homeRepository;
	public ResponseEntity<List<CustomOrder>> findAllOrders() {
		List<CustomOrder> orders;
		orders = homeRepository.findAllOrders();
		return ResponseEntity.status(HttpStatus.OK).body(orders.subList(0, 10));
	}
	
	public ResponseEntity<HomeDisplay> getAllTotals() {
		HomeDisplay homeDisplay;
		homeDisplay = new HomeDisplay(homeRepository.totalOrders(), homeRepository.totalProducts(), homeRepository.totalCategories(), homeRepository.totalProviders());
		return ResponseEntity.status(HttpStatus.OK).body(homeDisplay);
	}
}
