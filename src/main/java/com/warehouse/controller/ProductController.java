package com.warehouse.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.Product;
import com.warehouse.entity.User;
import com.warehouse.repository.ProductRepository;
import com.warehouse.service.ProductService;
import com.warehouse.service.ProviderService;

@RestController
@RequestMapping(path="api/v1/Products")
@CrossOrigin(origins = "http://localhost:4200")
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
	public ResponseEntity<Product> findById(@PathVariable int id) {
		Product product= (Product) productService.getProduct(id).getBody();
		return productService.getProduct(id);
	}
	@PostMapping("/insert")
	public ResponseEntity insertProduct(@RequestBody Product newProduct){
		
		return productService.insert(newProduct);

	}
	@PutMapping("/update/{id}")
	public ResponseEntity updateProduct(@RequestBody Product pod, @PathVariable int id){ 
		Product product= (Product) productService.getProduct(id).getBody();
		product.setName(pod.getName());
		product.setUnit(pod.getUnit());
		product.setAmount(pod.getAmount());
		product.setPrice(pod.getPrice());
		product.setCategory_id(pod.getCategory_id());
		product.setProvider_id(pod.getProvider_id());
			return productService.update(product);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteProduct(@PathVariable int id) {
		return productService.Delele(id);
		
				
	}
	@GetMapping("/search")
	public ResponseEntity<List<CustomProductDisplay>>searchCategory(@RequestParam(required = false) String product_name,@RequestParam(required = false) String category_name,@RequestParam(required = false) String provider_name )
	{
		
		return  productService.search(product_name,category_name,provider_name);
		
	}
}
