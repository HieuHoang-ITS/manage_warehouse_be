package com.warehouse.entity;

import java.util.List;

public class NewOrder {
	private Order order;
	private List<Order_Detail> details;

	public NewOrder() {
		super();
	}

	public NewOrder(Order order, List<Order_Detail> details) {
		super();
		this.order = order;
		this.details = details;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order_Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Order_Detail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "NewOrder [order=" + order + ", details=" + details + "]";
	}

}