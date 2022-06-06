package com.warehouse.repository;

import java.util.Date;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.CustomOrder;
import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.Order;
import com.warehouse.entity.ThongKeBaSanPhamDuocNhapNhieuNhat;
import com.warehouse.entity.ThongKeLoai;
import com.warehouse.entity.ThongKeSanPhamTheoThang;
import com.warehouse.entity.Thongke;
import com.warehouse.entity.ThongKeLoai;
//@Repository
//public interface OrderRepository extends JpaRepository<Order, Integer>{
//	
//}
import com.warehouse.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query("select sum(total_price)  from Order e where date_part('month', e.created_at)=?1")
	int sumtotal_Price(int thang);

	@Query("select new com.warehouse.entity.Thongke (EXTRACT(MONTH FROM created_at) as th,sum(f.amount*p.price))"
			+ " from Order t " + "join Order_Detail f"
			+ "	on t.id=f.order_id join Product p on f.product_id=p.id where t.trading_type like 'import'"
			+ "	group by EXTRACT(MONTH FROM created_at) order by th asc")
	List<Thongke> thongKeTheoThang();

	@Query("SELECT new com.warehouse.entity.ThongKeSanPhamTheoThang ( p.name,sum(t.total_price),COUNT( p.id) AS TONGSO)"
			+ " from Order t " + "join Order_Detail f" + "	on t.id=f.order_id join Product p on f.product_id=p.id"
			+ " WHERE EXTRACT(month from t.created_at) = ?1" + " AND EXTRACT( year from t.created_at) = ?2 "
			+ " AND t.trading_type  like 'export'" + " group by p.name, p.id")
	List<ThongKeSanPhamTheoThang> thongkesanphamtheothang(int thang, int nam);

	@Query("SELECT new com.warehouse.entity.ThongKeSanPhamTheoThang ( p.name,sum(t.total_price),COUNT( p.id) AS TONGSO)"
			+ " from Order t " + "join Order_Detail f" + "	on t.id=f.order_id join Product p on f.product_id=p.id"
			+ " WHERE EXTRACT(month from t.created_at) = ?1" + " AND EXTRACT( year from t.created_at) = ?2 "
			+ " AND t.trading_type  like 'import'" + " group by p.name, p.id")
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
	@Query("SELECT new com.warehouse.entity.ThongKeBaSanPhamDuocNhapNhieuNhat( p.name,sum(t.total_price),COUNT( p.id),p.id AS TONGSO)"
			+ " from Order t " + "join Order_Detail f" + "	on t.id=f.order_id join Product p on f.product_id=p.id"
			+ " WHERE EXTRACT(month from t.created_at) = ?1" + " AND EXTRACT( year from t.created_at) = ?2 "
			+ " AND t.trading_type  like 'import'"
			+ " group by p.name, p.id order by COUNT(p.id) desc, sum(t.total_price) desc")
	List<ThongKeBaSanPhamDuocNhapNhieuNhat> thongke3sanphamnhapnhieunhat(int thang, int nam);

	@Query(value = "Select new com.warehouse.entity.CustomOrder(o.id, o.user_id, "
			+ "o.trading_type, o.customer_name, o.customer_phone, o.status, o.description,"
			+ " o.total_price,us.full_name as user_name, o.created_at) From Order as o, User as"
			+ " us where o.trading_type=?1 and o.user_id = us.id and o.delete_flag=false")
	List<CustomOrder> findIEOrders(String type);

	@Query(value = "Select new com.warehouse.entity.CustomOrder(o.id, o.user_id, "
			+ "o.trading_type, o.customer_name, o.customer_phone, o.status, o.description,"
			+ " o.total_price,us.full_name as user_name, o.created_at) From Order as o, User as"
			+ " us where o.user_id = us.id and (o.status='1' or o.status='3')")
	List<CustomOrder> findAllProcessedOrders();

	@Query(value = "SELECT new com.warehouse.entity.CustomOrder(o.id, o.user_id,"
			+ " o.trading_type, o.customer_name, o.customer_phone, o.status, o.description,"
			+ " o.total_price,us.full_name as user_name, o.created_at) "
			+ " FROM Order as o JOIN User as us ON o.user_id = us.id" + " WHERE"
			+ " ((:type like 'record') or o.delete_flag=false)" + " and ((:id in (0)) or o.id=:id)"
			+ " and ((:user_id in (0)) or us.id=:user_id)" + " and ((:status is null) or o.status = :status)"
			+ " and (:date in (:nullDate) or (o.created_at >= :date and o.created_at<:da))"
			+ " and ((:type like 'record') or o.trading_type=:type)")
	List<CustomOrder> searchByFilter(int id, @Param("user_id") int uid, @Param("status") String status,
			@Param("date") Date date, @Param("nullDate") Date nullDate, @Param("da") Date dayAfter,
			@Param("type") String type);

	@Query(value = "SELECT new com.warehouse.entity.CustomProductDisplay("
			+ "pr.id, pro.id as provider_id, pr.name as product_name, ca.name as category_name, pro.name as provider_name, pro.address, pr.amount, pr.unit, ca.status, pr.price"
			+ ")" + "FROM Product as pr, Category as ca, Provider as pro "
			+ "WHERE pr.category_id = ca.id and pr.provider_id = pro.id and ca.status='In Use'")
	List<CustomProductDisplay> productImportDisplay();

	@Query(value = "SELECT new com.warehouse.entity.CustomProductDisplay("
			+ "pr.id, pro.id as provider_id, pr.name as product_name, ca.name as category_name, pro.name as provider_name, pro.address, pr.amount, pr.unit, ca.status, pr.price"
			+ ")" + "FROM Product as pr, Category as ca, Provider as pro "
			+ "WHERE pr.category_id = ca.id and pr.amount>0 and pr.provider_id = pro.id and ca.status='In Use'")
	List<CustomProductDisplay> productExportDisplay();

	@Query(value = "select o.id from trading_invoice as o order by o.id desc limit 1", nativeQuery = true)
	int getlastestIndex();

	@Query(value = "Select new com.warehouse.entity.User(us.id, us.full_name, us.email, us.tel, us.address) From User as us")
	List<User> findAllUser();

	@Transactional
	@Modifying
	@Query(value = "UPDATE trading_invoice SET delete_flag = true where id=:ids", nativeQuery = true)
	void deleteFlags(@Param("ids") int deleteID);

	@Query("select o from Order  o where o.status=?1 and o.trading_type=?2")
	List<Order> getALLOrderStatus(String status, String type);

	@Query("select o from Order o join User d on o.user_id=d.id where o.status='2' and "
			+ "((?3 in ('o'))  OR  o.trading_type like ?3)" + "AND ((?2 IN (0)) OR  d.id = ?2)"
			+ "AND ((?1 IN (0)) OR  o.id = ?1)" + "AND ((?4 IN (?5)) OR  o.created_at = ?4)")
	List<Order> search(int id1, int nguoiphutrach, String loai, Date date, Date date1);

	@Query("SELECT new com.warehouse.entity.ThongKeLoai(c.name, COUNT( p.id) AS TONGSO, sum(f.amount)) from Order_Detail f join Order"
			+ " o on f.order_id = o.id join Product p on p.id=f.product_id join Category c on p.category_id=c.id"
			+ " WHERE extract(month from o.created_at) = ?1 AND extract(year from o.created_at) = ?2 and o.trading_type='import'"
			+ " group by c.name")
	List<ThongKeLoai> Thongkeloainhap(int thang, int nam);

	@Query("SELECT new com.warehouse.entity.ThongKeLoai(c.name, COUNT( p.id) AS TONGSO, sum(f.amount)) from Order_Detail f join Order"
			+ " o on f.order_id = o.id join Product p on p.id=f.product_id join Category c on p.category_id=c.id"
			+ " WHERE extract(month from o.created_at) = ?1 AND extract(year from o.created_at) = ?2 and o.trading_type='export'"
			+ " group by c.name")
	List<ThongKeLoai> Thongkeloaixuat(int thang, int nam);
	
	@Query("select new com.warehouse.entity.Thongke (EXTRACT(MONTH FROM created_at) as th,sum(f.amount*p.price))"
			+ " from Order t " + "join Order_Detail f"
			+ "	on t.id=f.order_id join Product p on f.product_id=p.id where t.trading_type like 'import'"
			+ "	and (t.created_at>=?1 and t.created_at<?2)  group by EXTRACT(MONTH FROM created_at) order by th asc")
	List<Thongke> thongkeTheoKhoang(Date from, Date to);
}
