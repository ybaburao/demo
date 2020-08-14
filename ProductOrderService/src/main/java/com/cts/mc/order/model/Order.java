package com.cts.mc.order.model;

public class Order {
	private String userId; 
	private String orderId;
	private int productId;
	private int noOfUnits;
	
	
	
	public Order() {
	}
	
	public Order(String orderId, int productId, int noOfUnits,String userId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.noOfUnits = noOfUnits;
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
