package com.warehouse.entity;


public class DetailOrder_Display {
	private int id;
	private String product_name;
	private String category_name;
	private String provider_name;
	private String provider_address;
	private String provider_tel;
	private String product_unit;
	private String category_status;
	private int amount;
	
	
	public DetailOrder_Display(int id, String product_name, String category_name, String provider_name,
			String provider_address, String provider_tel, String product_unit, String category_status, int amount) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.category_name = category_name;
		this.provider_name = provider_name;
		this.provider_address = provider_address;
		this.provider_tel = provider_tel;
		this.product_unit = product_unit;
		this.category_status = category_status;
		this.amount = amount;
	}
	public String getProvider_address() {
		return provider_address;
	}
	public void setProvider_address(String provider_address) {
		this.provider_address = provider_address;
	}
	public DetailOrder_Display() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getProvider_tel() {
		return provider_tel;
	}
	public void setProvider_tel(String provider_tel) {
		this.provider_tel = provider_tel;
	}
	public String getProduct_unit() {
		return product_unit;
	}
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	public String getCategory_status() {
		return category_status;
	}
	public void setCategory_status(String category_status) {
		this.category_status = category_status;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
