package com.warehouse.entity;

import java.util.Date;

public class NewOrderSearch {
	private String id;
	private String uid;
	private String status;
	private String toDate;
	private String fromDate;
	
	public NewOrderSearch() {
		super();
	}

	public NewOrderSearch(String id, String uid, String status, String toDate, String fromDate) {
		super();
		this.id = id;
		this.uid = uid;
		this.status = status;
		this.toDate = toDate;
		this.fromDate = fromDate;
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

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	@Override
	public String toString() {
		return "NewOrderSearch [id=" + id + ", uid=" + uid + ", status=" + status + ", toDate=" + toDate + ", fromDate="
				+ fromDate + "]";
	}

}