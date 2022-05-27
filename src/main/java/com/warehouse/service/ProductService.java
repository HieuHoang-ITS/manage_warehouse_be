package com.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.warehouse.entity.Product;
import com.warehouse.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private final ProductRepository pdr;
	
	@Autowired ProductRepository productRepository;
	public ProductService(ProductRepository pdr) {
		super();
		this.pdr = pdr;
	}
	public List<Product> findAll()
	{
		return productRepository.findAll();
	}
	public ResponseEntity<List> getAllProduct() {
		// TODO Auto-generated method stub
		
		return ResponseEntity.status(HttpStatus.OK).body(pdr.findAll());
		
		
}
	public ResponseEntity insert(Product product){
		pdr.save(product);
	return ResponseEntity.status(HttpStatus.OK).body("Inser category successfully");
}
	public ResponseEntity update(Product pod, int id) {
		// TODO Auto-generated method stub
		Product newpod = pdr.findById(id).map(product -> {
			product.setName(pod.getName());
			product.setUnit(pod.getUnit());
			product.setAmount(pod.getAmount());
			product.setPrice(pod.getPrice());
			return pdr.save(product);
		}).orElseGet(() -> {
			pod.setId(id);
			return pdr.save(pod);

		});
		return ResponseEntity.status(HttpStatus.OK).body("update successfully");	
		}
	
	public ResponseEntity getProduct(int id) {

		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.OK).body(pdr.findById(id));
	}
	public ResponseEntity Delele(int id) {
		boolean exists = pdr.existsById(id);
		if (exists) {
			pdr.deleteById(id);
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
		return new ResponseEntity<String>("NOT_FOUND",HttpStatus.NOT_FOUND);
		
	}
	public List<Product> searchProduct(String search)
	{
		return productRepository.searchProduct(search);
	}
	public Optional<Product> getbyid(int id)
	{	
		return productRepository.findById(id);
	}
	public void insertOrUpdate(Product product)
	{
		productRepository.save(product);
	}

}
