package com.warehouse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.Order;
import com.warehouse.entity.Order_Detail;
import com.warehouse.entity.Product;
import com.warehouse.entity.TableDetail;
import com.warehouse.repository.OrderRepository;
import com.warehouse.service.OrderDetailService;
import com.warehouse.service.OrderService;
import com.warehouse.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired ProductService productService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String title)
	{
		if(title==null)
		{
			List<Product> products=productService.findAll();
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
		else {
			List<Product> products=productService.searchProduct(title);
			if(products.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<>(products, HttpStatus.OK);
		}
	}
	@GetMapping("/orderchoxacnhan")
	public ResponseEntity<List<Order>> getAllOrderStatus()
	{
		List<Order> orders=orderService.getAllOrderStatus("choxacnhan");
		if(orders.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
	}
	@PutMapping("/updateorder/{id}")
	public ResponseEntity<Order> updateOrderstatus(@PathVariable("id") int id, @RequestBody Order orderupdate)
	{
		Optional<Order> order=orderService.getorderbyId(id);
		if(order.isPresent())
		{
			Order order1=order.get();
			order1.setStatus(orderupdate.getStatus());
			if(orderupdate.getStatus().contains("thanhcong"))
			{
				//tim order detail
				Optional<List<Order_Detail>> orderDetails=orderDetailService.getOrderDetailbyOrder(order1.getId());
				if(orderDetails.isPresent())
				{
					List<Order_Detail> orderDetails1=orderDetails.get();
				    
					for (Order_Detail orderdetail : orderDetails1) {
						Optional<Product> product=productService.getbyid(orderdetail.getProduct_id());
						if(product.isPresent())
						{
							Product productt=product.get();
							productt.setAmount(orderdetail.getAmount()+productt.getAmount());
						}
					}
				}
				
				// update sanpham
			}
			orderService.insertOrUpdate(order1);
			return new ResponseEntity<Order>(order1, HttpStatus.OK);
		}
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}
	@GetMapping("tabledetail/{id}")
	public ResponseEntity<List<TableDetail>> getTableDetail(@PathVariable("id") int id)
	{
	Optional<List<Order_Detail>> orderDetails=orderDetailService.getOrderDetailbyOrder(id);
	if(orderDetails.isPresent())
	{
		List<Order_Detail> orderDetailss=orderDetails.get();
	}
		return new ResponseEntity<>(HttpStatus.OK);
	}

//	@GetMapping("/search")
//	public ResponseEntity<>()
	
}
