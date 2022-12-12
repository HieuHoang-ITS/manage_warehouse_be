package com.warehouse.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.DetailOrder_Display;
import com.warehouse.entity.NewOrder;
import com.warehouse.entity.NewOrderSearch;
import com.warehouse.entity.Order;
import com.warehouse.entity.Order_Detail;
import com.warehouse.entity.Product;
import com.warehouse.entity.User;
import com.warehouse.repository.OrderRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.service.system.OrderDetailService;
import com.warehouse.service.system.OrderService;
import com.warehouse.service.system.ProductService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	ProductRepository prRepository;

	@GetMapping("/export")
	public ResponseEntity<List<CustomOrder>> getAllExportOrders() {
		return orderService.findIEOrders("export");
	}

	@GetMapping("/import")
	public ResponseEntity<List<CustomOrder>> getAllImportOrders() {
		return orderService.findIEOrders("import");
	}

	@GetMapping("/record")
	public ResponseEntity<List<CustomOrder>> getAllRecordOrders() {
		return orderService.findAllProcessedOrders();
	}

	@GetMapping("/search")
	public ResponseEntity<List<CustomOrder>> getSearchByFilter(@RequestParam(required = false) String id,
			@RequestParam(required = false) String uid, @RequestParam(required = false) String status,
			@RequestParam(required = false) String toDate, @RequestParam(required = false) String fromDate,
			@RequestParam String type) throws ParseException {
		NewOrderSearch filter = new NewOrderSearch(id, uid, status, toDate, fromDate);
		return orderService.searchByFilter(filter, type);
	}

	@GetMapping("/register/product")
	public ResponseEntity<List<CustomProductDisplay>> getProduct(@RequestParam String type) {
		return orderService.findAllProduct(type);
	}

	@GetMapping("/register/user")
	public ResponseEntity<List<User>> getUser() {
		return orderService.findAllUser();
	}

	@PostMapping("/register/save")
	public ResponseEntity addNewOrder(@RequestBody @Valid NewOrder newOrder, BindingResult bindingResult)
			throws Exception {
		List<Order_Detail> newDetailList = newOrder.getDetails();
		List<Product> productAmountList = prRepository.dm();
		for (Order_Detail element : newDetailList) {
			if (element.getAmount() > getAmountByID(productAmountList, element.getProduct_id())) {
				if (newOrder.getOrder().getTrading_type().equalsIgnoreCase("export"))
					throw new ArithmeticException(
							"ID:" + element.getId() + " ordered an amount that is larger than available value");
			} else if (element.getAmount() <= 0) {
				throw new ArithmeticException("ID:" + element.getId() + " ordered an amount < 1");
			}
		}

		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			String errorMsg = "";
			for (String key : errors.keySet()) {
				String msg = "Lỗi ở: " + key + ", lí do: " + errors.get(key) + "\n";
				errorMsg += msg;
				System.out.println(msg);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
		}
		return orderService.add(newOrder);
	}
	

	@PutMapping("/change-delete-flag")
	public ResponseEntity updateDeleteFlag(@RequestBody int[] deleteIDs) {
		return orderService.deleteFlag(deleteIDs);
	}

	@GetMapping("/detail/{order_id}")
	public ResponseEntity<List<DetailOrder_Display>> getDetailOrder(@PathVariable int order_id) {
		System.out.println(order_id);
		return orderDetailService.findOrderDetails(order_id);
	}
	
	// Get product amount by ID
	int getAmountByID(List<Product> list, int id) {
		for (Product element : list) {
			if (element.getId() == id)
				return element.getAmount();
		}
		return 0;
	}
}
