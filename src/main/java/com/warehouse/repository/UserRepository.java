package com.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.warehouse.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}