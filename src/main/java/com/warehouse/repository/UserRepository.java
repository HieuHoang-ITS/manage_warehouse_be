package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.warehouse.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User as u WHERE (lower(u.full_name) like lower(CONCAT('%',?1,'%')) OR (?1 = null))"
			+ " AND"
			+ " (lower(u.email) like lower(CONCAT('%',?2,'%')) OR (?2 = null))"
			+ " AND"
			+ " (lower(u.tel) like lower(CONCAT('%',?3,'%')) OR (?3 = null))")
//	@Query ("select u from User as u WHERE (u.full_name like %?1% OR u.email like %?2% OR u.tel like %?3%)")
	List<User>search( String full_name, String email, String tel);
}
