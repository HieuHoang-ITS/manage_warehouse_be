package com.warehouse.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.entity.Order;
import com.warehouse.entity.ThongKeSanPhamTheoThang;
import com.warehouse.entity.Thongke;
import com.warehouse.repository.OrderRepository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.warehouse.entity.Order;
import com.warehouse.entity.Order_Detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.NewOrder;
import com.warehouse.entity.Order;
import com.warehouse.entity.User;
import com.warehouse.repository.OrderDetailRepository;
import com.warehouse.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderDetailRepository orderDetailRepository;

	public List<Thongke> th11()
	{
		return orderRepository.thongKeTheoThang();
	}
	public List<ThongKeSanPhamTheoThang> thongKeSanPhamTheoThang(int thang, int nam){
		return orderRepository.thongkesanphamtheothang(thang, nam);
	}
	public List<ThongKeSanPhamTheoThang> thongKeSanPhamTheoThangnhap(int thang, int nam){
		return orderRepository.thongkesanphamtheothangnhap(thang, nam);
	}

	public List<Order> getAllOrderStatus(String status, int type) {
		if (type == 1) {
			return orderRepository.getALLOrderStatus(status, "import");
		} else {
			return orderRepository.getALLOrderStatus(status, "export");
		}

	}
	public Optional<Order> getorderbyId(int id) {
		return orderRepository.findById(id);
	}

	public void insertOrUpdate(Order order) {
		orderRepository.save(order);
	}

	// @GetMapping("search/{madonhang}/{loai}/{ngaynhap}/{ngayxuat}/{nguoiphutrach}")
	// int madonhang, String loai, Date ngaynhap, Date ngayxuat, String nguoiphutrach
	 public List<Order> search(int madonhang, int nguoiphutrach, String ngay,String loai)
	 {
		 try {
			//Date sellDate = new SimpleDateFormat("yyyy-MM-dd").parse("1/1/19");
//			if(loai.contains(""))
//			{
//				String d=null;
//			 return orderRepository.search(madonhang,nguoiphutrach,d,ngay);
//			 return orderRepository.search(madonhang,nguoiphutrach,loai,ngay);
//			}
			 System.out.println(ngay);
			Date sellDate = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
			Date sellDa = new SimpleDateFormat("yyyy-MM-dd").parse("2000-10-10");
			System.out.println(sellDa);
//			System.out.println(ngay);
			return orderRepository.search(madonhang,nguoiphutrach,loai,sellDate,sellDa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return orderRepository.findAll();
	 }


	public ResponseEntity<List<CustomOrder>> findIEOrders(String type) {
		List<CustomOrder> orders;
		orders = orderRepository.findIEOrders(type);
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

	public ResponseEntity add(NewOrder newOrder) {
		// Insert to trading_invoice
		Order order = newOrder.getOrder();
		orderRepository.save(order);

		// Insert to detail_trading_invoice
		System.err.println(newOrder.getDetails().toString());
		Order_Detail order_Detail;
		int order_id = orderRepository.getlastestIndex();
		for (int i = 0; i < newOrder.getDetails().size(); i++) {
			order_Detail = new Order_Detail(newOrder.getDetails().get(i).getProduct_id(), order_id,
					newOrder.getDetails().get(i).getAmount());
			System.out.println(order_Detail);
			orderDetailRepository.save(order_Detail);
		}
		return ResponseEntity.status(HttpStatus.OK).body("New Order has been added");
	}

	public ResponseEntity<List<CustomProductDisplay>> findAllProduct() {
		List<CustomProductDisplay> products = orderRepository.findAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	public ResponseEntity<List<User>> findAllUser() {
		List<User> users = orderRepository.findAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

}
