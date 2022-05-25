package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.Category;
import com.warehouse.entity.Product;
import com.warehouse.service.CategoryService;
import com.warehouse.service.ProductService;

@RestController
@RequestMapping(path="api/v1/Products")
public class ProductController {
	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@GetMapping("")
	public ResponseEntity<List> getAll(){
		return productService.getAllProduct();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable int id) {
		return productService.getProduct(id);
	}
	@PostMapping("/insert")
	public ResponseEntity insertCategory(@RequestBody Product newProduct){
		
		return productService.insert(newProduct);

	}
	@PutMapping("/{id}")

	public ResponseEntity updateCategory(@RequestBody Product pod, @PathVariable int id) {
		return productService.update(pod, id);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> Deletecategory(@PathVariable int id) {
		return productService.Delele(id);
		
				
	}
}
