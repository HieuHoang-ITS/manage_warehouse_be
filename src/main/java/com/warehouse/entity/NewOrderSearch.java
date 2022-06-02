package com.warehouse.entity;

import java.util.Date;

public class NewOrderSearch {
	private String id;
	private String uid;
	private String status;
	private String date;

	public NewOrderSearch() {
		super();
	}

	public NewOrderSearch(String id, String uid, String status, String date) {
		super();
		this.id = id;
		this.uid = uid;
		this.status = status;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "NewOrderSearch [id=" + id + ", uid=" + uid + ", status=" + status + ", date=" + date + "]";
	}
	
}