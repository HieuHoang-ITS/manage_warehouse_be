package com.warehouse.entity;

import java.util.Date;
import java.util.List;

public class NewOrder {
	private String trading_type;
	private int user_id;
	private String customer_name;
	private String customer_phone;
	private String status;
	private int total_price;
	private Date created_at;
	private List<Order_Detail> details;
	
	
	public NewOrder(String trading_type, int user_id, String customer_name, String customer_phone, String status,
			int total_price, Date created_at, List<Order_Detail> details) {
		super();
		this.trading_type = trading_type;
		this.user_id = user_id;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.status = status;
		this.total_price = total_price;
		this.created_at = created_at;
		this.details = details;
	}
	public String getTrading_type() {
		return trading_type;
	}
	public void setTrading_type(String trading_type) {
		this.trading_type = trading_type;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public List<Order_Detail> getDetails() {
		return details;
	}
	public void setDetails(List<Order_Detail> details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "NewOrder [trading_type=" + trading_type + ", user_id=" + user_id + ", customer_name=" + customer_name
				+ ", customer_phone=" + customer_phone + ", status=" + status + ", total_price=" + total_price
				+ ", created_at=" + created_at + ", details=" + details + "]";
	}
	
	
	
	
}
