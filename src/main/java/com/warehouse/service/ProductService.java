package com.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.entity.Product;
import com.warehouse.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired ProductRepository productRepository;
	public List<Product> findAll()
	{
		return productRepository.findAll();
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
