package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.Order;
import com.warehouse.entity.ThongKeSanPhamTheoThang;
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
	@Query("SELECT new com.warehouse.entity.ThongKeSanPhamTheoThang ( p.name,sum(t.total_price),COUNT( p.id) AS TONGSO)"
			+ " from Order t "
			+ "join Order_Detail f"
			+ "	on t.id=f.order_id join Product p on f.product_id=p.id"
			+ " WHERE EXTRACT(month from t.created_at) = ?1"
			+ " AND EXTRACT( year from t.created_at) = ?2 "
			+ " AND t.trading_type  like 'export'"
			+ " group by p.name, p.id")
	List<ThongKeSanPhamTheoThang> thongkesanphamtheothang(int thang, int nam);
	@Query("SELECT new com.warehouse.entity.ThongKeSanPhamTheoThang ( p.name,sum(t.total_price),COUNT( p.id) AS TONGSO)"
			+ " from Order t "
			+ "join Order_Detail f"
			+ "	on t.id=f.order_id join Product p on f.product_id=p.id"
			+ " WHERE EXTRACT(month from t.created_at) = ?1"
			+ " AND EXTRACT( year from t.created_at) = ?2 "
			+ " AND t.trading_type  like 'import'"
			+ " group by p.name, p.id")
	List<ThongKeSanPhamTheoThang> thongkesanphamtheothangnhap(int thang, int nam);
//	SELECT p.name,sum(o.total_price),COUNT( p.id) AS TONGSO 
//	from detail_trading_invoice as od join trading_invoice as o on od.export_invoice_id=o.id join products as p on p.id=od.product_id 
//	WHERE extract(month from o.created_at) = 11 AND extract( year from o.created_at) = 2021 AND o.trading_type  like 'export'
//	group by p.name, p.id
//	@Query("select from sum(t.total_price) "
//			+ "Order t"
//			+ " join Order_Detail f"
//			+ "	on t.id=f.order_id join Product p on f.product_id=p.id"
//			+ " WHERE EXTRACT(month from t.created_at) = ?1"
//			+ " AND EXTRACT( year from t.created_at) = ?2 "
//			+ " AND t.trading_type  like 'import'"
//			+ " group by EXTRACT(month from t.created_at)"
//			)
//	int tongsonhap(int thang, int nam);
//	@Query("SELECT new com.warehouse.entity.ThongKeSanPhamTheoThang ( p.name,sum(t.total_price),COUNT( p.id) AS TONGSO)"
//			+ " from Order t "
//			+ "join Order_Detail f"
//			+ "	on t.id=f.order_id join Product p on f.product_id=p.id"
//			+ " WHERE EXTRACT(month from t.created_at) = ?1"
//			+ " AND EXTRACT( year from t.created_at) = ?2 "
//			+ " AND t.trading_type  like 'import'"
//			+ " group by p.name, p.id order by COUNT(p.id) desc")
//	List<ThongKeSanPhamTheoThang> thongke3sanphamnhapnhieunhat(int thang, int nam);
	
}
