package com.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.Category;

	@Repository
	public interface CategoryRepository extends JpaRepository<Category, Integer>{
		
	}

