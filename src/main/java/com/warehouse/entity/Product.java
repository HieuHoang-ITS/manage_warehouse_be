package com.warehouse.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	String name;
	String unit;
	int amount;
	int price;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "category_id", referencedColumnName = "id")
//	Category category;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "provider_id", referencedColumnName = "id")
//	Provider provider;
	int category_id;
	int provider_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amuont) {
		this.amount = amuont;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}
}
