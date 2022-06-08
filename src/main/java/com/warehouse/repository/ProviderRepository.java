package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.warehouse.entity.Provider;
import com.warehouse.entity.User;



@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
//	 @Query("SELECT e FROM Provider e ORDER BY e.id asc")
//	  List<Provider> dm();
	 @Query("select p from Provider as p WHERE ( lower(p.address) like lower(CONCAT('%',?1,'%')) OR (?1 = null))"
				+ " AND"
				+ " (lower(p.tel) like lower(CONCAT('%',?2,'%')) OR (?2 = null))")
	 List<Provider>search( String address, String tel);
}
