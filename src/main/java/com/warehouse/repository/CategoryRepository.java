package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.Category;

	@Repository
	public interface CategoryRepository extends JpaRepository<Category, Integer>{
		 @Query("SELECT c FROM Category as c  ORDER BY c.id asc")
		  List<Category> dm();
		 @Query("SELECT c FRom Category as c WHERE name like %?1%")
		 List<Category>search(String name);
		
	}

