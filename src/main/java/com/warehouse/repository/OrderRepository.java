package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.Order;
import com.warehouse.entity.Thongke;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query("select sum(total_price)  from Order e where date_part('month', e.created_at)=?1")
	int sumtotal_Price(int thang);
	@Query("select new com.warehouse.entity.Thongke (EXTRACT(MONTH FROM created_at) as th,sum(f.amount*p.price))"
			+ " from Order t "
			+ "join Order_Detail f"
			+ "	on t.id=f.order_id join Product p on f.product_id=p.id where t.trading_type like 'import'"
			+ "	group by EXTRACT(MONTH FROM created_at) order by th asc")
	List<Thongke> thongKeTheoThang();
}
