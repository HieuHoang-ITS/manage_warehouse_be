package com.warehouse.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.warehouse.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query("select o from Order  o where o.status=?1 and o.trading_type=?2")
	List<Order> getALLOrderStatus(String status, String type);
	@Query("select o from Order o join User d on o.user_id=d.id where "
			+"((?3 in ('0'))  OR  o.trading_type like ?3)"
			+"AND ((?2 IN (0)) OR  d.id = ?2)"
			+"AND ((?1 IN (0)) OR  o.id = ?1)"
			+"AND ((?4 IN (?5)) OR  o.created_at = ?4)")
	List<Order> search(int id1, int nguoiphutrach, String loai, Date date, Date date1);
}
//000 1/1/19