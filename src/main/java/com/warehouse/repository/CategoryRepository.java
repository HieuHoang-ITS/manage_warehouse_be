package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.Category;

	@Repository
	public interface CategoryRepository extends JpaRepository<Category, Integer>{
<<<<<<< HEAD
		 @Query("SELECT e FROM Category e ORDER BY e.id asc")
		  List<Category> dm();
=======
>>>>>>> 583fbde6685e5fffd971398f062aec3d009c03e1
	}

