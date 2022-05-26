package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query(value="Select new com.warehouse.entity.CustomOrder(o.id, o.user_id, o.trading_type, o.customer_name, o.customer_phone, o.status, o.description, o.total_price,us.full_name as user_name) From Order as o, User as us where o.trading_type=?1 and o.user_id = us.id")
	List<CustomOrder> findIEOrders(String type);
}
