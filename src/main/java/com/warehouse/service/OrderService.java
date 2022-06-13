package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.warehouse.entity.Order;
import com.warehouse.entity.ThongKeSanPhamTheoThang;
import com.warehouse.entity.Thongke;
import com.warehouse.repository.OrderRepository;
import com.warehouse.repository.ProductRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.warehouse.entity.Order;
import com.warehouse.entity.Order_Detail;
import com.warehouse.entity.ThongKeBaSanPhamDuocNhapNhieuNhat;
import com.warehouse.entity.ThongKeLoai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.NewOrder;
import com.warehouse.entity.NewOrderSearch;
import com.warehouse.entity.Order;
import com.warehouse.entity.User;
import com.warehouse.repository.OrderDetailRepository;
import com.warehouse.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderDetailRepository orderDetailRepository;

	public List<Thongke> th11() {
		return orderRepository.thongKeTheoThang();
	}

	public List<Thongke> thongkeTheoKhoang(String fromDate, String toDate) {
		Date from = new Date();
		Date to = new Date();

		try {
			from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
			to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
		} catch (Exception e) {
		}
		System.out.println("===== Date Check ====");
		System.out.println(from);
		System.out.println(to);
		return orderRepository.thongkeTheoKhoang(from, to);
	}

	public List<ThongKeSanPhamTheoThang> thongKeSanPhamTheoThang(int thang, int nam) {
		return orderRepository.thongkesanphamtheothang(thang, nam);
	}

	public List<ThongKeSanPhamTheoThang> thongKeSanPhamTheoThangnhap(int thang, int nam) {
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

	// int madonhang, String loai, Date ngaynhap, Date ngayxuat, String
	// nguoiphutrach
	public List<Order> search(int madonhang, int nguoiphutrach, String ngay, String loai) {
		try {
			System.out.println(ngay);
			Date sellDate = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
			Date sellDa = new SimpleDateFormat("yyyy-MM-dd").parse("0000-00-00");
			System.out.println(sellDa);
//			System.out.println(ngay);
			return orderRepository.search(madonhang, nguoiphutrach, loai, sellDate, sellDa);
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

	public ResponseEntity<List<CustomOrder>> findAllProcessedOrders() {
		List<CustomOrder> orders;
		orders = orderRepository.findAllProcessedOrders();
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

	public boolean checkString(String str) {
		if (str == null || str.length() < 0)
			return false;
		else if ("".equals(str.trim()))
			return false;
		else
			return true;
	}

	public ResponseEntity<List<CustomOrder>> searchByFilter(NewOrderSearch filter, String type) throws ParseException {
		List<CustomOrder> orders = null;
		int id = 0;
		int uid = 0;
		String status = null;
		Date nullDate = new SimpleDateFormat("yyyy-MM-dd").parse("0000-00-00");
		Date fromDate = nullDate;
		Date toDate = nullDate;

		if (checkString(filter.getId()))
			id = Integer.parseInt(filter.getId());
		if (checkString(filter.getUid()))
			uid = Integer.parseInt(filter.getUid());
		if (checkString(filter.getStatus()))
			status = filter.getStatus();
		if (checkString(filter.getFromDate()))
			try {
				fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(filter.getFromDate());
				toDate = new SimpleDateFormat("yyyy-MM-dd").parse(filter.getToDate());
				// get the day after
				Calendar c = Calendar.getInstance();
				c.setTime(toDate);
//				c.add(Calendar.DATE, 1);
				toDate = c.getTime();
			} catch (Exception e) {
			}
		System.out.println(
				"[" + id + " - " + uid + " - " + status + " - " + fromDate + " - " + toDate + " - " + type + "]");
		orders = orderRepository.searchByFilter(id, uid, status, nullDate, fromDate, toDate, type);
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}
	
	@Transactional
	public ResponseEntity add(NewOrder newOrder) {
		// Insert to trading_invoice
		Order order = newOrder.getOrder();
		orderRepository.save(order);

		// Insert to detail_trading_invoice
		System.err.println(newOrder.getDetails().toString());
		Order_Detail order_Detail;
		int order_id = orderRepository.getlastestIndex();
		for (int i = 0; i < newOrder.getDetails().size(); i++) {
			int productID = newOrder.getDetails().get(i).getProduct_id();
			int amount = newOrder.getDetails().get(i).getAmount();
			order_Detail = new Order_Detail(productID, order_id, amount);
			System.out.println(order_Detail);
			productRepository.updateProductAmountFromOrder(productID, amount);
			orderDetailRepository.save(order_Detail);
		}
		return ResponseEntity.status(HttpStatus.OK).body("New Order has been added");
	}

	public ResponseEntity<List<CustomProductDisplay>> findAllProduct(String type) {
		List<CustomProductDisplay> products;
		if (type.equalsIgnoreCase("import")) {
			products = orderRepository.productImportDisplay();
		} else {
			products = orderRepository.productExportDisplay();
		}
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	public ResponseEntity<List<User>> findAllUser() {
		List<User> users = orderRepository.findAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	public List<ThongKeLoai> thongKeLoainhap(int thang, int nam) {
		return orderRepository.Thongkeloainhap(thang, nam);
	}

	public List<ThongKeLoai> thongKeLoaixuat(int thang, int nam) {
		return orderRepository.Thongkeloaixuat(thang, nam);
	}

	public ResponseEntity deleteFlag(int[] deleteIDs) {
		for (int i : deleteIDs) {
			orderRepository.deleteFlags(i);
		}
		return ResponseEntity.status(HttpStatus.OK).body("Deleted ID=[" + deleteIDs + "]");
	}

	public List<ThongKeBaSanPhamDuocNhapNhieuNhat> thongKe3sanphamnhapnhieunhat(int thang, int nam) {
		List<ThongKeBaSanPhamDuocNhapNhieuNhat> products;
		List<ThongKeBaSanPhamDuocNhapNhieuNhat> subProducts;

		products = orderRepository.thongke3sanphamnhapnhieunhat(thang, nam);
		subProducts = products.subList(0, 3);

		return subProducts;
	}

}
