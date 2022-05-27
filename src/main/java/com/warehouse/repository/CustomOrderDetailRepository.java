//package com.warehouse.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import com.warehouse.entity.DetailOrder_Display;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface CustomOrderDetailRepository extends JpaRepository<DetailOrder_Display, Integer>{
////	@Query(value="SELECT o.id, pr.name as product_name, ca.name as category_name, pro.name as provider_name, pro.address, pro.tel, pr.unit, ca.status, o.amount "
////			+ "FROM detail_trading_invoice as o, products as pr, Categories as ca, providers as pro "
////			+ "WHERE o.export_invoice_id= :orderid and o.product_id = pr.id and pr.category_id = ca.id and pr.provider_id = pro.id", nativeQuery = true)
////	List<DetailOrder_Display> findAllOrderID(@Param("orderid")int orderid);
//
//}
