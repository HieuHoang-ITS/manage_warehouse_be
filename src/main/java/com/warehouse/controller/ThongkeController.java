package com.warehouse.controller;

import java.util.List;

import org.apache.coyote.http11.Http11AprProtocol;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.ThongKeSanPhamTheoThang;
import com.warehouse.entity.Thongke;
import com.warehouse.service.OrderService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ThongkeController {
	@Autowired 
	OrderService orderService;
	@GetMapping("/thang1")
	public ResponseEntity<List<Thongke>> thongKethang(){
		return new ResponseEntity<>(orderService.th11(), HttpStatus.OK);
	}
	@GetMapping("/thongkesanphamtheothang/{thang}/{nam}")
	public ResponseEntity<List<ThongKeSanPhamTheoThang>> thongketheothang(@PathVariable("thang") int thang,@PathVariable("nam") int nam){
		return new ResponseEntity<List<ThongKeSanPhamTheoThang>>(orderService.thongKeSanPhamTheoThang(thang, nam),HttpStatus.OK);
	}
	@GetMapping("/thongkesanphamtheothangnhap/{thang}/{nam}")
	public ResponseEntity<List<ThongKeSanPhamTheoThang>> thongketheothangnhap(@PathVariable("thang") 
	int thang,@PathVariable("nam") int nam){
		return new ResponseEntity<List<ThongKeSanPhamTheoThang>>(orderService.thongKeSanPhamTheoThangnhap(thang, nam),HttpStatus.OK);
	}

}
