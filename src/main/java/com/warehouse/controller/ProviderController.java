package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.warehouse.entity.Provider;
import com.warehouse.entity.User;
import com.warehouse.service.ProviderService;
@RestController
@RequestMapping(path = "api/v1/Providers")
@CrossOrigin(origins = "http://localhost:4200")
public class ProviderController {
	@Autowired
	private ProviderService providerService;

	public ProviderController(ProviderService providerService) {
		super();
		this.providerService = providerService;
	}

	@GetMapping("")
	public ResponseEntity<List> getAll() {
		return providerService.getAllProvider();

	}

	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable int id) {
		return providerService.getProvider(id);
	}

	@PostMapping("/insert")
	public ResponseEntity insertProvider(@RequestBody Provider newProvider) {
		return providerService.insert(newProvider);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity updateCategory(@RequestBody Provider pvd, @PathVariable int id) {
		Provider provider= (Provider) providerService.getProvider(id).getBody();
		provider.setName(pvd.getName());
		provider.setAddress(pvd.getAddress());
		provider.setStatus(pvd.getStatus());
		provider.setTel(pvd.getTel());
		return providerService.update(provider);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> Deletecategory(@PathVariable int id) {
		return providerService.Delele(id);

	}

	@GetMapping("/by/{id}")
	public Provider findid(@PathVariable int id) {
		return providerService.getproviderbyId(id).get();
	}
	@GetMapping("/search")
	public ResponseEntity<List<Provider>>searchProvider(@RequestParam(required = false) String address,@RequestParam(required = false) String tel )
	{
		
		return providerService.search(address, tel);
		
	}
}
