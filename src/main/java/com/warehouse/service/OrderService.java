package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.entity.Order;
import com.warehouse.entity.ThongKeSanPhamTheoThang;
import com.warehouse.entity.Thongke;
import com.warehouse.repository.OrderRepository;
@Service
public class OrderService {
	@Autowired OrderRepository orderRepository;
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
//	public int tongsoluongnhap()
//	{
//		return 
//	}
//	public List<ThongKeSanPhamTheoThang> thongKebaSanPhamTheoThang(int thang, int nam){
//		return orderRepository.thongke3sanphamnhapnhieunhat(thang, nam);
//	}
}
