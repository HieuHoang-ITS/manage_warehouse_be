package com.warehouse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.warehouse.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User as u WHERE (lower(u.full_name) like lower(CONCAT('%',?1,'%')) OR (?1 = null))" + " AND"
            + " (lower(u.email) like lower(CONCAT('%',?2,'%')) OR (?2 = null))" + " AND"
            + " (lower(u.tel) like lower(CONCAT('%',?3,'%')) OR (?3 = null))")
    List<User> search(String full_name, String email, String tel);

    Optional<User> findByUsername(String userName);
}
