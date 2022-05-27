package com.warehouse.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
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

import com.warehouse.entity.Category;
import com.warehouse.entity.Order;
import com.warehouse.entity.Order_Detail;
import com.warehouse.entity.Product;
import com.warehouse.entity.Provider;
import com.warehouse.entity.TableDetail;
import com.warehouse.entity.User;
import com.warehouse.repository.CategoryRepository;
import com.warehouse.repository.OrderRepository;
import com.warehouse.repository.UserRepository;
import com.warehouse.service.CategoryService;
import com.warehouse.service.OrderDetailService;
import com.warehouse.service.OrderService;
import com.warehouse.service.ProductService;
import com.warehouse.service.ProviderService;
import com.warehouse.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired UserService userService;
	@Autowired ProductService productService;
	@Autowired
	OrderService orderService;
	@Autowired 
	CategoryService categoryService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	ProviderService proviService;
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
	@GetMapping("/orderchoxacnhan/{type}")
	public ResponseEntity<List<Order>> getAllOrderStatus(@PathVariable("type") int type)
	{
	
		List<Order> orders=orderService.getAllOrderStatus("choxacnhan",type);
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
			order1.setDescription(orderupdate.getDescription());
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
							if(orderupdate.getTrading_type().contains("import"))
							{
							productt.setAmount(orderdetail.getAmount()+productt.getAmount());
							productService.insertOrUpdate(productt);
							}
							if(orderupdate.getTrading_type().contains("export"))
							{
							productt.setAmount(productt.getAmount()-orderdetail.getAmount());
							productService.insertOrUpdate(productt);
							}
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
		List<TableDetail> tableDetails=new ArrayList<TableDetail>();
		Optional<Order> order=orderService.getorderbyId(id);
		
			Order order1=order.get();
			Optional<User> user=(Optional<User>) userService.getUser(order1.getUser_id()).getBody();
		Optional<List<Order_Detail>> orderDetails=orderDetailService.getOrderDetailbyOrder(id);
		if(orderDetails.isPresent())
		{
			List<Order_Detail> orderDetailss=orderDetails.get();
			for (Order_Detail order_Detail : orderDetailss) {
				Optional<Product> product=productService.getbyid(order_Detail.getProduct_id());
				if(product.isPresent())
				{
					Product productt=product.get();
					Category category=(Category) categoryService.getCategory(productt.getCategory_id()).getBody();
					Provider provider= (Provider) proviService.getProvider(productt.getId()).getBody();
					TableDetail tableDetail=new TableDetail();
					tableDetail.setNamesanpham(productt.getName());
					tableDetail.setGia(productt.getPrice());
					tableDetail.setLoai(category.getName());
					//System.out.print("dddddddddddd dddd "+provider.get().getName());
					tableDetail.setNhacungcap(provider.getName());
					tableDetail.setSoluong(order_Detail.getAmount());
					tableDetail.setGia(productt.getPrice());
					tableDetail.setNameuser(user.get().getFull_name());
					tableDetails.add(tableDetail);
				}
			}
			return new ResponseEntity<List<TableDetail>>(tableDetails,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	@GetMapping("/search")
//	public ResponseEntity<>()
	//  + danh sách để tìm kiếm (mã đơn hàng,loại(nhập/xuât), ngày nhập hàng, ngày xuất hàng, người phụ trách)
//	@GetMapping("search/{madonhang}/{loai}/{ngaynhap}/{ngayxuat}/{nguoiphutrach}")
//	public ResponseEntity<Order> searchHoadon(@PathVariable("madonhang") int madonhang, @PathVariable("loai") String loai, @PathVariable("ngaynhap") Date ngaynhap, @PathVariable("ngayxuat") Date ngayxuat, @PathVariable("nguoiphutrach") String nguoiphutrach  ){
//		return 
//	}
//	@GetMapping("/search/{madonhang}/{loai}/{ngaynhap}/{ngayxuat}/{nguoiphutrach}")
//	public ResponseEntity<List<Order>> searchHoadon(@PathVariable(required = false) int madonhang,
//			@PathVariable(required = false) String loai, @PathVariable(required = false) Date ngaynhap,
//			@PathVariable(required = false) Date ngayxuat, @PathVariable(required = false) String nguoiphutrach  ){
//		String search;
//	  if(madonhang>0)
//	  {
////		  search+=""
//	  }
//		return new ResponseEntity<List<Order>>(orderService.search(), HttpStatus.OK);
//	}
	@GetMapping("/search/{madonhang}/{nguoiphutrach}")
	public ResponseEntity<List<Order>> searcHoadon(@PathVariable(required = false) int madonhang,
			@PathVariable(required = false) int nguoiphutrach , @RequestParam(required = false) Date ngay,
			@RequestParam(required = false) String loai ){
		return new ResponseEntity<List<Order>>(orderService.search(madonhang, nguoiphutrach, ngay,loai), HttpStatus.OK);
	}
	@GetMapping("/getuser")
	public ResponseEntity<List<User>> getAllUser()
	{
		return userService.getAllUser();
	}
}
