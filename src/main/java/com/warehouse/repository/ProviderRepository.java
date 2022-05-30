package com.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.entity.Provider;



@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}
