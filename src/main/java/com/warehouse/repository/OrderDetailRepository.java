package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.Order_Detail;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order_Detail, Integer>{
	@Query("Select dti From Order_Detail dti where dti.order_id=?1")
	List<Order_Detail> findAllByOrderID(int order_id);
	
}
