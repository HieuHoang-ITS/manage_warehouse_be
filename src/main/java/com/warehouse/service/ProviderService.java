package com.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.warehouse.entity.Provider;
import com.warehouse.repository.ProviderRepository;

@Service
public class ProviderService {
	@Autowired
	ProviderRepository pr;
	public ProviderService(ProviderRepository pr) {
		super();
		this.pr = pr;
	}
	public ResponseEntity<List> getAllProvider() {
		// TODO Auto-generated method stub
		
		return ResponseEntity.status(HttpStatus.OK).body(pr.findAll());
		
		
}
	public ResponseEntity insert(Provider provider){
		pr.save(provider);
	return ResponseEntity.status(HttpStatus.OK).body("Inser category successfully");
}
	public ResponseEntity update(Provider pvd, int id) {
		// TODO Auto-generated method stub
		Provider newPv = pr.findById(id).map(provider -> {
			provider.setName(pvd.getName());
//			provider.setStatus(pvd.getStatus());
//			provider.setAddress(pvd.getStatus());
			provider.setTel(pvd.getTel());
			return pr.save(provider);
		}).orElseGet(() -> {
			pvd.setId(id);
			return pr.save(pvd);

		});
		return ResponseEntity.status(HttpStatus.OK).body("update successfully");	
		}
	
	public ResponseEntity<Provider> getProvider(int id) {

		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.OK).body(pr.findById(id).get());
	}
	public ResponseEntity Delele(int id) {
		boolean exists = pr.existsById(id);
		if (exists) {
			pr.deleteById(id);
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
		return new ResponseEntity<String>("NOT_FOUND",HttpStatus.NOT_FOUND);
		
	}
	public Optional<Provider> getproviderbyId(int id)
	{
		return pr.findById(id);
	}
}
