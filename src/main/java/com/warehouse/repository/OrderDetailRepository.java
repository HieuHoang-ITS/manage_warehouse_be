package com.warehouse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.Order_Detail;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order_Detail, Integer>{
	@Query("select e from Order_Detail e where e.order_id=?1")
	List<Order_Detail>getOrderDetailbyOrder(int order_id);
}
