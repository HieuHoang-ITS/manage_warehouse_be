package com.warehouse.entity;

public class ThongKeLoai {
	String nameloai;
	long tongsanpham;
	long tongsoluong;
	Double phantram;
	public Double getPhantram() {
		return phantram;
	}
	public void setPhantram(Double phantram) {
		this.phantram = phantram;
	}
	public ThongKeLoai(String nameloai, long tongsanpham, long tongsoluong) {
		super();
		this.nameloai = nameloai;
		this.tongsanpham = tongsanpham;
		this.tongsoluong = tongsoluong;
	}
	public String getNameloai() {
		return nameloai;
	}
	public void setNameloai(String nameloai) {
		this.nameloai = nameloai;
	}
	public long getTongsanpham() {
		return tongsanpham;
	}
	public void setTongsanpham(long tongsanpham) {
		this.tongsanpham = tongsanpham;
	}
	public long getTongsoluong() {
		return tongsoluong;
	}
	public void setTongsoluong(long tongsoluong) {
		this.tongsoluong = tongsoluong;
	}

}
