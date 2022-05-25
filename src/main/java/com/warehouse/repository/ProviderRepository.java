package com.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.entity.Provider;




public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}
