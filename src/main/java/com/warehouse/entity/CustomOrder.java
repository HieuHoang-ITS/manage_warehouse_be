package com.warehouse.entity;

import java.util.Date;

public class CustomOrder{
	private int id;
	int user_id;
	String trading_type;
	String customer_name;
	String customer_phone;
	String status;
	String description;
	int total_price;
	private String user_name;
	
	
	public CustomOrder(int id, int user_id, String trading_type, String customer_name, String customer_phone,
			String status, String description, int total_price, String user_name) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.trading_type = trading_type;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.status = status;
		this.description = description;
		this.total_price = total_price;
		this.user_name = user_name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTrading_type() {
		return trading_type;
	}

	public void setTrading_type(String trading_type) {
		this.trading_type = trading_type;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
