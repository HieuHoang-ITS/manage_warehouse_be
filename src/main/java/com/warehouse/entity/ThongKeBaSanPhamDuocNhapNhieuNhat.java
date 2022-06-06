package com.warehouse.entity;

public class ThongKeBaSanPhamDuocNhapNhieuNhat {
	private int id;
	private String name ;
	private long total_price;
	long soluong;
	public ThongKeBaSanPhamDuocNhapNhieuNhat(String name, long total_price,long soluong, int id) {
		super();
		this.name = name;
		this.total_price = total_price;
		this.soluong=soluong;
		this.id = id;
	}
	
	public long getSoluong() {
		return soluong;
	}

	public void setSoluong(long soluong) {
		this.soluong = soluong;
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
	public long getTotal_price() {
		return total_price;
	}
	public void setTotal_price(long total_price) {
		this.total_price = total_price;
	}
	public long getId() {
		return id;
	}

}
