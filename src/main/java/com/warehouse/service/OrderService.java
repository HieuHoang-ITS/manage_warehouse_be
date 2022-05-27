package com.warehouse.service;

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
import com.warehouse.repository.OrderRepository;

@Service
public class OrderService {
 @Autowired
 OrderRepository orderRepository;
 public List<Order> getAllOrderStatus(String status, int type)
 {
	 if(type==1)
	 {
		 return orderRepository.getALLOrderStatus(status, "import");
	 }
	 else {
		 return orderRepository.getALLOrderStatus(status, "export");
	 }
	 
 }
 public Optional<Order> getorderbyId(int id)
 {
	return orderRepository.findById(id);
 }
 public void insertOrUpdate(Order order)
 {
	 orderRepository.save(order);
 }
// @GetMapping("search/{madonhang}/{loai}/{ngaynhap}/{ngayxuat}/{nguoiphutrach}")
// int madonhang, String loai, Date ngaynhap, Date ngayxuat, String nguoiphutrach
 public List<Order> search(int madonhang, int nguoiphutrach, Date ngay,String loai)
 {
	 try {
		//Date sellDate = new SimpleDateFormat("yyyy-MM-dd").parse("1/1/19");
//		if(loai.contains(""))
//		{
//			String d=null;
//		 return orderRepository.search(madonhang,nguoiphutrach,d,ngay);
//		 return orderRepository.search(madonhang,nguoiphutrach,loai,ngay);
//		}
		Date sellDat = new SimpleDateFormat("yyyy-MM-dd").parse("2011-01-18");
		Date sellDa = new SimpleDateFormat("yyyy-MM-dd").parse("2011-01-18");
		System.out.println(sellDat);
		return orderRepository.search(0,0,"import",sellDat,sellDa);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return orderRepository.findAll();
 }
}
