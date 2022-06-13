package com.warehouse.repository;

import java.util.List;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.CustomProductDisplay;
import com.warehouse.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("select e from Product e where e.name like ?1")
	List<Product> searchProduct(String search);

	@Query("SELECT e FROM Product e ORDER BY e.id asc")
	List<Product> dm();

	@Query(value = "SELECT new com.warehouse.entity.CustomProductDisplay("
			+ "pr.id, pro.id as provider_id, pr.name as product_name, ca.name as category_name, pro.name as provider_name, pro.address, pr.amount, pr.unit, ca.status, pr.price"
			+ ")" + "FROM Product as pr, Category as ca, Provider as pro "
			+ "WHERE pr.category_id = ca.id and pr.provider_id = pro.id")
	List<CustomProductDisplay> findAllProduct();

	@Query("SELECT new com.warehouse.entity.CustomProductDisplay("
			+ "pr.id, pro.id as provider_id, pr.name as product_name, ca.name as category_name, pro.name as provider_name, pro.address, pr.amount, pr.unit, ca.status, pr.price"
			+ ")" + "FROM Product as pr, Category as ca, Provider as pro "
			+ "WHERE pr.category_id = ca.id and pr.provider_id = pro.id " + "and "
			+ "(lower(pr.name) like lower(CONCAT('%',?1,'%'))OR (?1=null)) " + "and "
			+ "(lower(ca.name) like lower(CONCAT('%',?2,'%'))OR (?2=null))" + "and"
			+ "(lower(pro.name) like lower(CONCAT('%',?3,'%'))OR (?3=null))")
	List<CustomProductDisplay> search(String product_name, String category_name, String provider_name);

	@Modifying
	@Query(value = "UPDATE Product SET amount = (amount) + (:amount) where id=:id")
	void updateProductAmountFromOrder(@Param("id") int id, @Param("amount") int amount);
}
