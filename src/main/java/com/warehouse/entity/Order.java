package com.warehouse.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "trading_invoice")
public class Order {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int user_id;
	private String trading_type;
	@NotEmpty(message="Customer Name is required")
	private String customer_name;
	@NotEmpty(message="Customer Phone is required")
	private String customer_phone;
	private String status;
	private String description;
	private int total_price;
	private boolean delete_flag; 
	private Date created_at;

	public Order() {
		super();
	}
	public Order( int user_id, String trading_type, String customer_name, String customer_phone, String status,
			String description, int total_price, Date created_at) {
		super();
		this.user_id = user_id;
		this.trading_type = trading_type;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.status = status;
		this.description = description;
		this.total_price = total_price;
		this.created_at = created_at;
	}
	
	public Order(int id, int user_id, String trading_type, String customer_name, String customer_phone, String status,
			String description, int total_price, boolean delete_flag, Date created_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.trading_type = trading_type;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.status = status;
		this.description = description;
		this.total_price = total_price;
		this.delete_flag = delete_flag;
		this.created_at = created_at;
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
	
	public boolean isDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(boolean delete_flag) {
		this.delete_flag = delete_flag;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}
