package com.warehouse.entity;

public class Thongke {
	int thang;
	Long gia;
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public Thongke(int thang, Long gia) {
		super();
		this.thang = thang;
		this.gia = gia;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	
}
