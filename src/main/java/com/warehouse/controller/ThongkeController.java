package com.warehouse.controller;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.service.OrderService;

@RestController
public class ThongkeController {
	@Autowired 
	OrderService orderService;
	@GetMapping("/thang")
	public ResponseEntity<Integer> thongKethang(){
		return new ResponseEntity<>(orderService.th11(), HttpStatus.OK);
	}

}
