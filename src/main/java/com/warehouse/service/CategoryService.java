package com.warehouse.service;
import org.springframework.stereotype.Service;
import com.warehouse.entity.Category;
import com.warehouse.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class CategoryService {
	@Autowired
	private final CategoryRepository cr;
	public CategoryService(CategoryRepository cr) {
		super();
		this.cr = cr;
	}
	public ResponseEntity<List> getAllCategorys() {
		// TODO Auto-generated method stub
		List<Category> cas=cr.dm();//sap seeps tawng dan
		return ResponseEntity.status(HttpStatus.OK).body(cas);
		
		
}
	public ResponseEntity insert(Category category){
		cr.save(category);
	return ResponseEntity.status(HttpStatus.OK).body("Inser category successfully");
}
	public ResponseEntity update(Category ctg) {
		cr.save(ctg);
		return ResponseEntity.status(HttpStatus.OK).body("update successfully");	
		}

	public ResponseEntity getCategory(int id) {

		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.OK).body(cr.findById(id).get());
	}
	public ResponseEntity Delele(int id) {
		System.out.println();
		boolean exists = cr.existsById(id);
		if (exists) {
			cr.deleteById(id);
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
		return new ResponseEntity<String>("NOT_FOUND",HttpStatus.NOT_FOUND);
		
	}
	public List<Category> search(String name) {
		try {
			return cr.search(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cr.findAll();
	}
	
}
