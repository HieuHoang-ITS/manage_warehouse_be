package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.HomeDisplay;
import com.warehouse.entity.User;

public interface HomeRepository extends JpaRepository<User, Integer> {
	@Query(value = "Select new com.warehouse.entity.CustomOrder(o.id, o.user_id, o.trading_type, o.customer_name, o.customer_phone, o.status, o.description, o.total_price,us.full_name as user_name, o.created_at) From Order as o, User as us where o.user_id = us.id order by o.created_at desc")
	List<CustomOrder> findAllOrders();
	
	@Query(value = "Select count(o.id) as totalOrders from Order as o")
	Integer totalOrders();
	@Query(value = "Select count(pr.id) as totalProducts from Product as pr")
	Integer totalProducts();
	@Query(value = "Select count(ca.id) as totalCategories from Category as ca")
	Integer totalCategories();
	@Query(value = "Select count(pro.id) as totalProviders from Provider as pro")
	Integer totalProviders();
}
