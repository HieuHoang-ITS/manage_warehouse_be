package com.warehouse.entity;

public class CustomProductDisplay {
	private int id;
	private int provider_id;
	private String product_name;
	private String category_name;
	private String provider_name;
	private String provider_address;
	private int amount;
	private String unit;
	private String category_status;
	private int price;
	
	
	public CustomProductDisplay(int id, int provider_id, String product_name, String category_name,
			String provider_name, String provider_address, int amount, String unit, String category_status, int price) {
		super();
		this.id = id;
		this.provider_id = provider_id;
		this.product_name = product_name;
		this.category_name = category_name;
		this.provider_name = provider_name;
		this.provider_address = provider_address;
		this.amount = amount;
		this.unit = unit;
		this.category_status = category_status;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public String getProvider_address() {
		return provider_address;
	}
	public void setProvider_address(String provider_address) {
		this.provider_address = provider_address;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCategory_status() {
		return category_status;
	}
	public void setCategory_status(String category_status) {
		this.category_status = category_status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
