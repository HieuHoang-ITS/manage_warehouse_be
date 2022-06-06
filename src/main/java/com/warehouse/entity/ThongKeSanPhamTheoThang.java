package com.warehouse.entity;

public class ThongKeSanPhamTheoThang {
	String name;
	long total_price;
	long amount;
	public ThongKeSanPhamTheoThang(String name, long total_price, long amount) {
		super();
		this.name = name;
		this.total_price = total_price;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTotal_price() {
		return total_price;
	}
	public void setTotal_price(long total_price) {
		this.total_price = total_price;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
}
