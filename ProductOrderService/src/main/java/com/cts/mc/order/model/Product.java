package com.cts.mc.order.model;

public class Product {
	private int productId;
	private String productName;
	private int stock;
	private Double price;
	private Double offer;
	
	
	public Product() {
		super();
	}
	public Product(int productId ,String productName, int stock, Double price, Double offer) {
		super();
		this.productId=productId;
		this.productName = productName;
		this.stock = stock;
		this.price = price;
		this.offer = offer;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getOffer() {
		return offer;
	}
	public void setOffer(Double offer) {
		this.offer = offer;
	}
	

}
