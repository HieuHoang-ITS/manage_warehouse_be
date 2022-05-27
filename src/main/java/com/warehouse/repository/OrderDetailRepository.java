package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.DetailOrder_Display;
import com.warehouse.entity.Order_Detail;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order_Detail, Integer> {

	@Query("select e from Order_Detail e where e.order_id=?1")
	List<Order_Detail> getOrderDetailbyOrder(int order_id);

	@Query(value = "SELECT "
			+ "new com.warehouse.entity.DetailOrder_Display(o.id, pr.name as product_name, ca.name as category_name, pro.name as provider_name, pro.address, pro.tel, pr.unit, ca.status, o.amount)"
			+ "FROM Order_Detail as o, Product as pr, Category as ca, Provider as pro "
			+ "WHERE o.order_id= :orderid and o.product_id = pr.id and pr.category_id = ca.id and pr.provider_id = pro.id")
	List<DetailOrder_Display> findAllOrderID(@Param("orderid") int orderid);
}

//}
