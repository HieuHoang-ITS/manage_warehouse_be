package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
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
import com.warehouse.repository.CategoryRepository;
import com.warehouse.service.CategoryService;

@RestController
@RequestMapping(path="api/v1/Categories")
public class CategoryController {
@Autowired
private CategoryService categoryService;

public CategoryController(CategoryService categoryService) {
	super();
	this.categoryService = categoryService;
}
@GetMapping("")
public ResponseEntity<List> getAll(){
	return categoryService.getAllCategorys();
	
}
@GetMapping("/{id}")
public ResponseEntity findById(@PathVariable int id) {
	return categoryService.getCategory(id);
}
@PostMapping("/insert")
public ResponseEntity insertCategory(@RequestBody Category newCategory){
	
	return categoryService.insert(newCategory);

}
@PutMapping("/{id}")

public ResponseEntity updateCategory(@RequestBody Category ctg, @PathVariable int id) {
	return categoryService.update(ctg, id);
	
}
@DeleteMapping("/{id}")
public ResponseEntity<String> Deletecategory(@PathVariable int id) {
	return categoryService.Delele(id);
	
			
}
}