package com.warehouse.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.Order;
//@Repository
//public interface OrderRepository extends JpaRepository<Order, Integer>{
//	
//}
import com.warehouse.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query(value = "Select new com.warehouse.entity.CustomOrder(o.id, o.user_id, o.trading_type, o.customer_name, o.customer_phone, o.status, o.description, o.total_price,us.full_name as user_name) From Order as o, User as us where o.trading_type=?1 and o.user_id = us.id")
	List<CustomOrder> findIEOrders(String type);

	@Query(value = "SELECT new com.warehouse.entity.CustomProductDisplay("
			+ "pr.id, pr.name as product_name, ca.name as category_name, pro.name as provider_name, pro.address, pr.amount, pr.unit, ca.status, pr.price"
			+ ")" + "FROM Product as pr, Category as ca, Provider as pro "
			+ "WHERE pr.category_id = ca.id and pr.provider_id = pro.id")
	List<CustomProductDisplay> findAllProduct();

	@Query(value = "Select new com.warehouse.entity.User(us.id, us.full_name, us.email, us.tel, us.address) From User as us")
	List<User> findAllUser();

	@Query("select o from Order  o where o.status=?1 and o.trading_type=?2")
	List<Order> getALLOrderStatus(String status, String type);

	@Query("select o from Order o join User d on o.user_id=d.id where " + "((?3 in ('0'))  OR  o.trading_type like ?3)"
			+ "AND ((?2 IN (0)) OR  d.id = ?2)" + "AND ((?1 IN (0)) OR  o.id = ?1)"
			+ "AND ((?4 IN (?5)) OR  o.created_at = ?4)")
	List<Order> search(int id1, int nguoiphutrach, String loai, Date date, Date date1);
}
