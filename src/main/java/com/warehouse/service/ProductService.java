package com.warehouse.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.Product;
import com.warehouse.entity.User;
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
		List<Product> cas=pdr.dm();
		return ResponseEntity.status(HttpStatus.OK).body(cas);
}
	public ResponseEntity insert(Product product){
		pdr.save(product);
	return ResponseEntity.status(HttpStatus.OK).body("Inser category successfully");
}
	public ResponseEntity update(Product pod) {
		// TODO Auto-generated method stub
		pdr.save(pod);
		return ResponseEntity.status(HttpStatus.OK).body("update successfully");	
		}
	
	public ResponseEntity getProduct(int id) {

		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.OK).body(pdr.findById(id).get());
	}
	public ResponseEntity Delele(int id) {
		boolean exists = pdr.existsById(id);
		if (exists) {
			pdr.deleteById(id);
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
		return new ResponseEntity<String>("NOT_FOUND",HttpStatus.NOT_FOUND);
		
	}
	public boolean checkString(String str) {
		if (str == null || str.length() < 0)
			return false;
		else if ("".equals(str.trim()))
			return false;
		else
			return true;
	}
	public ResponseEntity<List<CustomProductDisplay>>search(String product_name,String category_name,String provider_name){
		List<CustomProductDisplay> usr;
		
		String nameproduct=null;
		String namecategory=null;
		String nameprovider=null;
		if(checkString(product_name)) {
			nameproduct=product_name;
		}
		if(checkString(category_name)) {
			namecategory=category_name;
		}
		if(checkString(provider_name)) {
			nameprovider=provider_name;
		}
		usr = pdr.search(nameproduct,namecategory,nameprovider);
		return ResponseEntity.status(HttpStatus.OK).body(usr);
				
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
