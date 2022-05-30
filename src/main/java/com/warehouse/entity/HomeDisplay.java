package com.warehouse.entity;

public class HomeDisplay {
	private int totalOrders;
	private int totalProducts;
	private int totalCategories;
	private int totalProviders;
	
	public HomeDisplay() {
		super();
	}

	public HomeDisplay(int totalOrders, int totalProducts, int totalCategories, int totalProviders) {
		super();
		this.totalOrders = totalOrders;
		this.totalProducts = totalProducts;
		this.totalCategories = totalCategories;
		this.totalProviders = totalProviders;
	}

	public int getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}

	public int getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}

	public int getTotalCategories() {
		return totalCategories;
	}

	public void setTotalCategories(int totalCategories) {
		this.totalCategories = totalCategories;
	}

	public int getTotalProviders() {
		return totalProviders;
	}

	public void setTotalProviders(int totalProviders) {
		this.totalProviders = totalProviders;
	}

	@Override
	public String toString() {
		return "HomeDisplay [totalOrders=" + totalOrders + ", totalProducts=" + totalProducts + ", totalCategories="
				+ totalCategories + ", totalProviders=" + totalProviders + "]";
	}
	
	
}
