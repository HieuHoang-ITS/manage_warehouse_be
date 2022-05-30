package com.warehouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detail_trading_invoice")
public class Order_Detail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	
	public Order_Detail() {
		super();
	}
	public Order_Detail(int product_id, int order_id, int amount) {
		super();
		this.product_id = product_id;
		this.order_id = order_id;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Order_Detail [id=" + id + ", product_id=" + product_id + ", order_id=" + order_id + ", amount=" + amount
				+ "]";
	}

	int product_id;
	@Column(name="export_invoice_id")
	int order_id;
	int amount;

}
